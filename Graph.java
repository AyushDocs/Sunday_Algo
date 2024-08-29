package Sunday_Algos;

class Graph {
        public int[][] adjMatrix;
        private int n;
        private boolean isUndirected;
    
        Graph(int n,boolean isUndirected) {
            this.n = n;
            this.isUndirected=isUndirected;
            adjMatrix = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    adjMatrix[i][j] = 0;
        }
    
        public void addEdge(int a, int b,int weight) {
            adjMatrix[a][b] = weight;
            if(isUndirected) adjMatrix[b][a] = weight;
        }
        public void addEdge(int a, int b) {
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;
        }
    
        public void displayGraph() {
            for (int i = 0; i < n; i++) {
                System.out.print(i + "->");
                for (int j = 0; j < n; j++) {
                    if (adjMatrix[i][j] == 1) {
                        System.out.print(j);
                        if (j != n - 1)
                            System.out.print(",");
                    }
                }
            }
        }
    public static void main(String[] args) {
        
    }
}
