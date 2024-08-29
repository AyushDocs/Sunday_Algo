package Sunday_Algos;

import java.util.Arrays;

public class NegativeCycleDetector {
    private static int[] distance;
    private static int[][] graph;
    public static boolean detectNegativeCycle(int[][] graph1, int V) {
        // Array to store the shortest distance from the source to each vertex
        distance = new int[V];
        graph=graph1;
        // Initialize distances from source to all other vertices as INFINITY
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0; // Assuming the source is vertex 0

        // Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (edgeExists(u, v) && distance[u] != Integer.MAX_VALUE 
                        && distance[u] + graph[u][v] < distance[v]) {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (edgeExists(u, v) && distance[u] != Integer.MAX_VALUE 
                    && distance[u] + graph[u][v] < distance[v]) {
                    return true; // Negative cycle detected
                }
            }
        }

        return false; // No negative cycle found
    }
    private static boolean edgeExists(int u, int v) {
        return graph[u][v] != 0;
    }
}
