package Sunday_Algos;
public class CycleDetector {
    boolean cycleIsPresent(int graph[][],int currentNode,int parentNode,boolean visited[]){
        visited[currentNode]=true;
        for(int node:graph[parentNode]){
            if(!visited[node])
                if(cycleIsPresent(graph, node, currentNode, visited)){
                    return true;
                }
                else if(node!=currentNode) {
                    return true;
                }
        }
        return false;
    }
    boolean helper(int graph[][]){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i])
                return cycleIsPresent(graph,i,0,visited);
        }
        return false;
    }
}
