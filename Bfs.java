package Sunday_Algos;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    static void bfs(int [][]graph,int startingNode){
        int size=graph.length;
        boolean visited[]=new boolean[size];
        Queue<Integer> q=new LinkedList<>();

        visited[startingNode]=true;
        q.add(startingNode);

        while(!q.isEmpty()){
            int ele=q.remove();
            for(int i=0;i<size;i++){
                if(graph[ele][i]!=0 && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}