package Sunday_Algos;

import java.util.Arrays;

//gets mst 
public class KruskalAlgorithm {
    
    // A utility function to find set of an element i (uses path compression technique)
    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    static void union(int parent[], int rank[], int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    static void kruskalMST(int[][] graph) {
        int n = graph.length;
        int[][] result = new int[n - 1][3]; // To store the resultant MST
        int[] parent = new int[n];
        int[] rank = new int[n];

        Arrays.fill(rank,0);
        
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int[][] edges = new int[n * (n - 1) / 2][3]; // To store all edges
        int k = 0;

        // Store all edges from the adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] != 0) {
                    edges[k][0] = i;
                    edges[k][1] = j;
                    edges[k][2] = graph[i][j];
                    k++;
                }
            }
        }

        // Sort all edges in non-decreasing order of their weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int e = 0; // Index used to store edges in result[]
        k = 0; // Index used to iterate over sorted edges

        while (e < n - 1 && k < edges.length) {
            int[] next_edge = edges[k++];

            int x = find(parent, next_edge[0]);
            int y = find(parent, next_edge[1]);

            // If including this edge doesn't cause cycle, include it in the result
            if (x != y) {
                result[e++] = next_edge;
                union(parent, rank, x, y);
            }
        }

        // Print the resultant MST
        System.out.println("Edges in the constructed MST:");
        for (int i = 0; i < e; i++) {
            System.out.println(result[i][0] + " -- " + result[i][1] + " == " + result[i][2]);
        }
    }
}
