package edu.berkeley.cs.succinctgraph.neo4jbench;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static edu.berkeley.cs.succinctgraph.neo4jbench.BenchUtils.*;

public class BenchNeighbor {
    private static final long WARMUP_TIME = (long) (60 * 1E9); // 60 seconds
    private static final long MEASURE_TIME = (long) (120 * 1E9); // 120 seconds
    private static final long COOLDOWN_TIME = (long) (10 * 1E9); // 10 seconds

    private static int WARMUP_N = 500000;
    private static int MEASURE_N = 500000;

    public static void main(String[] args) {
        String type = args[0];
        String db_path = args[1];
        String warmup_query_path = args[2];
        String query_path = args[3];
        String output_file = args[4];
        WARMUP_N = Integer.parseInt(args[5]);
        MEASURE_N = Integer.parseInt(args[6]);
        String neo4jPageCacheMemory;
        if (args.length >= 8) {
            neo4jPageCacheMemory = args[7];
        } else {
            neo4jPageCacheMemory = GraphDatabaseSettings.pagecache_memory
                .getDefaultValue();
        }

        List<Long> warmupQueries = new ArrayList<>();
        List<Long> queries = new ArrayList<>();
        BenchUtils.getNeighborQueries(warmup_query_path, warmupQueries);
        BenchUtils.getNeighborQueries(query_path, queries);

        if (type.equals("neighbor-latency")) {
            benchNeighborLatency(db_path,
                neo4jPageCacheMemory, warmupQueries, queries, output_file);
        } else if (type.equals("neighbor-throughput")) {
            benchNeighborThroughput(
                db_path, warmupQueries, queries, output_file);
        }
    }

    private static void benchNeighborLatency(
        String db_path, String neo4jPageCacheMem,
        List<Long> warmupQueries, List<Long> queries, String output_file) {

        System.out.println("Benchmarking getNeighbor queries");
        //System.out.println("Setting neo4j's dbms.pagecache.memory: " + neo4jPageCacheMem);
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
            .newEmbeddedDatabaseBuilder(db_path)
            .setConfig(GraphDatabaseSettings.cache_type, "none")
            //.setConfig(GraphDatabaseSettings.pagecache_memory, neo4jPageCacheMem)
            .newGraphDatabase();

        BenchUtils.registerShutdownHook(graphDb);
        Transaction tx = graphDb.beginTx();
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(output_file)));
            PrintWriter resOut = null;
            if (System.getenv("BENCH_PRINT_RESULTS") != null) {
                resOut = new PrintWriter(new BufferedWriter(
                    new FileWriter(output_file + ".neo4j_result")));
            }

            fullWarmup(graphDb);
            System.out.println("Warming up for " + WARMUP_N + " queries");
            for (int i = 0; i < WARMUP_N; i++) {
                if (i % 10000 == 0) {
                    tx.success();
                    tx.close();
                    tx = graphDb.beginTx();
                }
                List<Long> neighbors = getNeighborsSorted(
                    graphDb, modGet(warmupQueries, i));
//                if (neighbors.size() == 0) {
//                    System.err.println("Error: no results for neighbor of " + warmupQueries[i % warmupQueries.length]);
//                }
            }

            System.out.println("Measuring for " + MEASURE_N + " queries");
            // measure
            for (int i = 0; i < MEASURE_N; i++) {
                if (i % 10000 == 0) {
                    tx.success();
                    tx.close();
                    tx = graphDb.beginTx();
                }
                long queryStart = System.nanoTime();
                List<Long> neighbors = getNeighborsSorted(
                    graphDb, modGet(queries, i));
                long queryEnd = System.nanoTime();
                double microsecs = (queryEnd - queryStart) / ((double) 1000);
                out.println(neighbors.size() + "," + microsecs);

                if (resOut != null) {
                    // correctness validation
                    Collections.sort(neighbors);
//                    BenchUtils.print("node id: " + queries[i % queries.length], neighbors, resOut);
                }
            }

            tx.success();
            out.close();
            if (resOut != null) resOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printMemoryFootprint();
            System.out.println("Shutting down database ...");
            graphDb.shutdown();
        }
    }

    private static void benchNeighborThroughput(String db_path,
        List<Long> warmupQueries, List<Long> queries, String output_file) {

        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabase(db_path);
        BenchUtils.registerShutdownHook(graphDb);
        Transaction tx = graphDb.beginTx();
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(output_file, true)));
            // warmup
            System.out.println("Warming up neo4j neighbor throughput");
            int i = 0;
            long warmupStart = System.nanoTime();
            while (System.nanoTime() - warmupStart < WARMUP_TIME) {
                List<Long> neighbors = getNeighbors(graphDb,
                    modGet(warmupQueries, i));
//                if (neighbors.size() == 0)
//                    System.err.println("Error: no results found in neo4j neighbor throughput benchmarking");
                i++;
            }

            // measure
            System.out.println("Measuring neo4j neighbor throughput");
            i = 0;
            long edges = 0;
            double totalSeconds = 0;
            long start = System.nanoTime();
            while (System.nanoTime() - start < MEASURE_TIME) {
                if (i % 10000 == 0) {
                    tx.success();
                    tx.close();
                    tx = graphDb.beginTx();
                }
                long queryStart = System.nanoTime();
                List<Long> neighbors = getNeighbors(graphDb,
                    modGet(queries, i));
                long queryEnd = System.nanoTime();
//                if (neighbors.size() == 0)
//                    System.err.println("Error: no results found in neo4j neighbor throughput benchmarking");

                totalSeconds += (queryEnd - queryStart) / ((double) 1E9);
                edges += neighbors.size();
                i++;
            }
            double getNeighborThput = ((double) i) / totalSeconds;
            double edgesThput = ((double) edges) / totalSeconds;

            // cooldown
            System.out.println("cooling down neo4j neighbor throughput");
            i = 0;
            long cooldownStart = System.nanoTime();
            while (System.nanoTime() - cooldownStart < COOLDOWN_TIME) {
                List<Long> neighbors = getNeighbors(graphDb,
                    modGet(warmupQueries, i));
                i++;
            }

            System.out.println("neighbor throughput: " + getNeighborThput);
            System.out.println("edge throughput: " + edgesThput);

            tx.success();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Shutting down database ...");
            graphDb.shutdown();
        }
    }

    public static List<Long> getNeighbors(GraphDatabaseService graphDb,
                                          long id) {
        List<Long> neighbors = new LinkedList<>();
        Node n = graphDb.getNodeById(id);
        Iterable<Relationship> rels = n.getRelationships(Direction.OUTGOING);
        for (Relationship r : rels) {
            neighbors.add(r.getOtherNode(n).getId());
        }
        return neighbors;
    }

    public static List<Long> getNeighborsSorted(GraphDatabaseService graphDb,
                                                long id) {
        Node n = graphDb.getNodeById(id);
        Iterable<Relationship> rels = n.getRelationships(Direction.OUTGOING);

        List<TimestampedId> timestampedNhbrs = new ArrayList<TimestampedId>();
        long timestamp, nhbrId;
        for (Relationship r : rels) {
            timestamp = (long) (r.getProperty("timestamp"));
            nhbrId = r.getOtherNode(n).getId();
            timestampedNhbrs.add(new TimestampedId(timestamp, nhbrId));
        }

        List<Long> neighbors = new ArrayList<Long>(timestampedNhbrs.size());
        Collections.sort(timestampedNhbrs);
        for (TimestampedId timestampedId : timestampedNhbrs) {
            neighbors.add(timestampedId.id);
        }
        return neighbors;
    }

}
