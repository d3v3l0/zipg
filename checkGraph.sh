#!/bin/bash

num_nodes=$1
neo4j_path=data/neo4j/$num_nodes
graph_path=data/edges/${num_nodes}.edge

java -cp target/scala-2.10/succinctgraph-assembly-0.1.0-SNAPSHOT.jar \
  -verbose:gc \
  edu.berkeley.cs.succinctgraph.neo4jbench.CheckGraph \
  $neo4j_path $graph_path
