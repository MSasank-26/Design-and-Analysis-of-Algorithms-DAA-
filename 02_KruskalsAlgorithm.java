
// Program 2: Kruskal's Algorithm

import java.util.*;

class Edge implements Comparable<Edge> {

    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalsAlgorithm {

    int V, E;
    Edge edge[];

    KruskalsAlgorithm(int v, int e) {

        V = v;
        E = e;

        edge = new Edge[e];

        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    int find(int parent[], int i) {

        if (parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        parent[x] = y;
    }

    void kruskalMST() {

        Edge result[] = new Edge[V];

        for (int i = 0; i < V; i++)
            result[i] = new Edge();

        Arrays.sort(edge);

        int parent[] = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int e = 0;
        int i = 0;

        while (e < V - 1) {

            Edge nextEdge = edge[i++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {

                result[e++] = nextEdge;

                union(parent, x, y);
            }
        }

        System.out.println("Edges in MST:");

        for (i = 0; i < e; i++) {

            System.out.println(result[i].src +
                    " - " +
                    result[i].dest +
                    " : " +
                    result[i].weight);
        }
    }

    public static void main(String[] args) {

        KruskalsAlgorithm graph =
                new KruskalsAlgorithm(4, 5);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}
