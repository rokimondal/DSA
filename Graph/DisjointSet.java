import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DisjointSet {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static int kruskalMst(ArrayList<Edge> graph, int v) {
        Collections.sort(graph);

        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < v - 1; i++) {
            Edge e = graph.get(i);
            if (find(e.src) != find(e.dest)) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        return mstCost;
    }

    public static void main(String[] args) {
        int v = n;
        init();
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        System.out.println(kruskalMst(graph, v));
    }
}
