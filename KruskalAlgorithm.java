package Sunday_Algos;
import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};

class Subset {
    int parent, rank;
};

public class KruskalAlgorithm {

    int no_of_vertices, no_of_edges;
    Edge[] edges;

    KruskalAlgorithm(int v, int e) {
        no_of_vertices = v;
        no_of_edges = e;
        edges = new Edge[no_of_edges];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void kruskalMST() {
        Edge[] result = new Edge[no_of_vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < no_of_vertices; ++i)
            result[i] = new Edge();

        Arrays.sort(edges);

        Subset[] subsets = new Subset[no_of_vertices];
        for (i = 0; i < no_of_vertices; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < no_of_vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < no_of_vertices - 1) {
            Edge next_edge = edges[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning tree : " + minimumCost);
    }

    public static void main(String[] args) {

        int V = 4;
        int E = 5;
        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        graph.kruskalMST();
    }
}
