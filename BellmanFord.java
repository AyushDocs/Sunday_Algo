package Sunday_Algos;

import java.util.Arrays;

//finds shortest distance between sorce vertex and all other vertices even 
//if negative edges exist using dynamic programming
public class BellmanFord {
    private static final int INF = Integer.MAX_VALUE;

    public static void bellmanFord(int[][] graph, int source) {
        int n = graph.length;
        int dist[] = new int[n];

        // Step 1: Initialize distances from source to all vertices as infinite, except the source itself.
        Arrays.fill(dist, INF);
        dist[source] = 0;

        // Step 2: Relax all edges |V| - 1 times.
        for (int i = 1; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    boolean edgeExists = graph[u][v] != 0;
                    boolean reductionConditionIsSatisfied = dist[u] + graph[u][v] < dist[v];
                    if (edgeExists && dist[u] != INF && reductionConditionIsSatisfied) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Step 3: Check for negative-weight cycles.
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains a negative-weight cycle");
                    return;
                }
            }
        }

        // Print the calculated shortest distances
        System.out.println("Vertex distances from source " + source + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Vertex " + i + " - Distance: " + (dist[i] == INF ? "INF" : dist[i]));
        }
    }
}
