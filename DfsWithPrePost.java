package Sunday_Algos;

public class DfsWithPrePost {

    // Variables to track pre and post values
    private static int preCount = 0;
    private static int postCount = 0;
    private static int[] pre;
    private static int[] post;

    // Function to perform DFS and record pre and post values
    public static void dfs(int[][] adjMatrix, int v, boolean[] visited) {
        visited[v] = true;
        pre[v] = preCount++;  // Record pre-order value
        System.out.println("Pre-order of vertex " + v + " is " + pre[v]);

        // Visit all adjacent vertices
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v][i] != 0 && !visited[i]) {
                dfs(adjMatrix, i, visited);
            }
        }

        post[v] = postCount++;  // Record post-order value
        System.out.println("Post-order of vertex " + v + " is " + post[v]);
    }
}
