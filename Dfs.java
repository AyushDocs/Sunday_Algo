package Sunday_Algos;

public class Dfs {
    private static void DFS(int graph[][],int starting_node,boolean visited[]){
        visited[starting_node]=true;

        for(int i=0;i<visited.length;i++)
            if(graph[starting_node][i]!=0){
                System.out.println(starting_node);
                DFS(graph, starting_node,visited);
            }
    }
    static void DfsCaller(int graph[][],int starting_node){
        int size=graph[0].length;
        boolean visited[]=new boolean[size];
        DFS(graph, starting_node, visited);
    }
}