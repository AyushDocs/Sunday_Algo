package Sunday_Algos;
import java.util.*;

public class LongestPathInDag {
    // Function to perform topological sort
    private static void topologicalSort(int v, boolean[] visited, Stack<Integer> stack, int[][] adjMatrix) {
        visited[v] = true;

        for (int i = 0; i < adjMatrix.length; i++) {
            boolean edgeExists = adjMatrix[v][i] != 0;
            boolean nodeNotYetVisited = !visited[i];
            if (edgeExists && nodeNotYetVisited) 
                topologicalSort(i, visited, stack, adjMatrix);
        }
            
        
        stack.push(v);
    }

    // Function to find the longest path in DAG
    public static int[] findLongestPath(int[][] adjMatrix, int source) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Perform topological sort
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adjMatrix);
            }
        }

        // Initialize distances to all vertices as negative infinity
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[source] = 0;

        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int currentEle = stack.pop();

            // Update distances of all adjacent vertices
            if (dist[currentEle] != Integer.MIN_VALUE) {
                for (int i = 0; i < n; i++) {
                    boolean edgeExists = adjMatrix[currentEle][i] != 0;
                    if (edgeExists && dist[i] < dist[currentEle] + adjMatrix[currentEle][i]) {
                        dist[i] = dist[currentEle] + adjMatrix[currentEle][i];
                    }
                }
            }
        }

        return dist;
    }
}
