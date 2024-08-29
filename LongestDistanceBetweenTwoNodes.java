package Sunday_Algos;
import java.util.*;

public class LongestDistanceBetweenTwoNodes {
    public static int getShortestDistance(int graph[][],int startingNode,int endingNode){
        if(startingNode==endingNode)return 0;

        int n=graph.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]*=-1;

        boolean visited[]=new boolean[n];
        int distance[]=new int[n];
        Queue<Integer> q=new LinkedList<>();

        visited[startingNode]=true;
        distance[0]=0;
        q.add(startingNode);
        
        while(!q.isEmpty()){
            int ele=q.poll();
            for(int i=0;i<n;i++){
                if(graph[ele][i]!=0 && visited[i]==false){
                    q.add(i);
                    visited[ele]=true;
                    distance[i]=distance[ele]+1;
                    if(i==endingNode)return distance[i];
                }
            }
        }
        return -1;
    }
}