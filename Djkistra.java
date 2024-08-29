package Sunday_Algos;
import java.util.*;

public class Djkistra {
    void dijkstra(int graph[][],int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>(graph.length, new Node());
        int[] dist = new int[graph.length];
        
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(src, 0));
        dist[src] = 0;

        // Loop until the priority queue is empty
        while (!pq.isEmpty()) {
            // Extract the vertex with the minimum distance from the priority queue
            int u = pq.poll().node;

            // Traverse all adjacent vertices of u
            for(int i=0;i<graph.length;i++){
                if(graph[u][i]!=0){
                    int v=i;
                    int weight=graph[u][i];
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }
    }
}
class Node implements Comparator<Node> {
    int node;
    int cost;

    public Node() {}

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node n1, Node n2) {
        return Integer.compare(n1.cost, n2.cost);
    }
}

