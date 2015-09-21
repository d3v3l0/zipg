#!/bin/bash
set -e

#### Steps:
# 1. modify the configs
# 2. bash init.sh
# FIXME: the manual installation somehow doesn't work; use 0.9.2
# 3. bash sbin/hosts-sudo.sh sudo bash /vol0/succinct-graph/build_thrift.sh
# 4. build on this machine as well:
#       sudo bash ./build_thrift.sh && cmake . && make -j
# 5. Set the desired settings in rates-bench.sh

node_file_raw=/vol0/twitter2010-40attr16each-tpch.node
edge_file_raw=/vol0/twitter2010-npa128sa32isa64.assoc

# L0, by default
npa=128
sa=32
isa=64

copyShardFiles=T

#### Initial setup

currDir=$(cd $(dirname $0); pwd)
. "${currDir}/sbin/succinct-config.sh"
. "${currDir}/sbin/load-succinct-env.sh"

bash ./init.sh

#### Copy the corresponding shard files over
if [[ -n $copyShardFiles ]]; then
  limit=$(($TOTAL_NUM_SHARDS - 1))
  padWidth=${#limit}
  paddedTotalNumShards=$(printf "%0*d" ${padWidth} ${TOTAL_NUM_SHARDS})
  for shard_id in `seq 0 $limit`; do
      # transfer shard id i to an appropriate host
      host_id=$(($shard_id % num_hosts))
      host=$(sed -n "$(($host_id + 1)){p;q;}" ${currDir}/conf/hosts)
  
      padded_shard_id=$(printf "%0*d" ${padWidth} ${shard_id})
      node_split="${node_file_raw}-part${padded_shard_id}of${paddedTotalNumShards}"
      edge_split="${edge_file_raw}-part${padded_shard_id}of${paddedTotalNumShards}"
  
      # Encoded succinct dirs
      # Hacky: note this uses internal impl details about namings of encoded tables
      nodeTbl="${node_split}WithPtrs.succinct"
      # This replaces the last 'assoc' by 'edge_table'
      edgeTbl=$(echo -n "${edge_split}.succinct" | sed 's/\(.*\)assoc\(.*\)/\1edge_table\2/')
  
      if [[ ! -d "${nodeTbl}" ]]; then
        echo "dir ${nodeTbl} doesn't exist, exiting"
        exit 1
      fi
      if [[ ! -d "${edgeTbl}" ]]; then
        echo "dir ${edgeTbl} doesn't exist, exiting"
        exit 1
      fi
  
      echo "shard_id: ${shard_id}, host_id ${host_id}"

      d1=$(dirname "${nodeTbl}")
      d2=$(dirname "${edgeTbl}")
      rsync -arL ${nodeTbl} ${host}:$d1 &
      rsync -arL ${edgeTbl} ${host}:$d2 &
  done
  wait
  echo "Shard files copied to all servers."
fi
wait

#### Launch aggregator & shards on all hosts

function stop_all() {
  bash ${currDir}/sbin/stop-all.sh 
  sleep 2
}

function start_all() {
  ${currDir}/sbin/start-servers.sh $node_file_raw $edge_file_raw $sa $isa $npa
  sleep 2

  ${currDir}/sbin/start-handlers.sh 
  sleep 2
}

function timestamp() {
  date +"%D-%T"
}

stop_all

bash ${currDir}/sbin/hosts.sh source "${currDir}/sbin/succinct-config.sh"
bash ${currDir}/sbin/hosts.sh source "${currDir}/sbin/load-succinct-env.sh"
sleep 2

start_all

#### Launch benchmark
threads=(16 32 64)

for throughput_threads in ${threads[*]}; do
    for bench in get_nodes2 get_nhbrsNode get_nhbrsAtype getEdgeAttrs get_nhbrs tao_mix mix; do
      bash ${currDir}/sbin/hosts.sh \
        rm -rf throughput_${bench}-npa128sa32isa64-${throughput_threads}clients.txt
    done
done

for throughput_threads in ${threads[*]}; do
    stop_all

    bash ${currDir}/sbin/hosts.sh \
      bash ${currDir}/scripts/rates-bench.sh \
      $node_file_raw $edge_file_raw $throughput_threads
    # TODO: kill based on timings?

    for bench in get_nodes2 get_nhbrsNode get_nhbrsAtype getEdgeAttrs get_nhbrs tao_mix mix; do
      rm -rf thput
      bash ${currDir}/sbin/hosts.sh \
        tail -n1 throughput_${bench}-npa128sa32isa64-${throughput_threads}clients.txt | \
        cut -d',' -f2 | \
        cut -d' ' -f2 >>thput
      if [[ ! "$(wc -l thput | cut -d' ' -f 1)" == $num_hosts ]]; then
        # some bench is not run
        continue
      fi
      cat thput # check each host serves roughly the same # of queries

      f="thput-${bench}-${throughput_threads}clients.txt"
      t=$(timestamp)
      echo "$t,$bench" >>${f}
      cat thput >> ${f}

      entry="$t,$bench,${throughput_threads}*10,$(awk '{ sum += $1 } END { print sum }' thput)"
      echo $entry
      echo $entry >> thput-summary
    done

    start_all
done
