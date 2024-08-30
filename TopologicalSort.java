package Sunday_Algos;

import java.util.*;

public class TopologicalSort {
    // Function to perform topological sort using an adjacency matrix
    static void topologicalSort(int[][] adjMatrix, int vertices) {
        int[] inDegree = new int[vertices];
        
        // Calculate in-degrees of all vertices
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] != 0) {
                    inDegree[j]++;
                }
            }
        }

        // Create a queue and enqueue all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // List to store the topological order
        List<Integer> topoOrder = new ArrayList<>();

        // Process vertices in queue
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            // Decrease the in-degree of all adjacent vertices of u
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[u][v] != 0) {
                    inDegree[v]--;
                    // If in-degree becomes 0, add it to the queue
                    if (inDegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }

        // Check if topological sort was possible (DAG check)
        if (topoOrder.size() != vertices) {
            System.out.println("The graph has a cycle, topological sort not possible.");
        } else {
            System.out.println("Topological Order: " + topoOrder);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        int[][] adjMatrix = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}
        };

        topologicalSort(adjMatrix, vertices);
    }
}
