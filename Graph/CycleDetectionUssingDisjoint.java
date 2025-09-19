import java.util.ArrayList;

public class CycleDetectionUssingDisjoint {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 1));

    }

    public static int find(int par[], int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par, par[x]);
    }

    public static boolean union(int rank[], int par[], int a, int b) {
        int parA = find(par, a);
        int parB = find(par, b);
        if (parA == parB) {
            return true;
        }

        if (rank[parA] < rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else {
            par[parB] = parA;
            rank[parA]++;
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        int par[] = new int[graph.length];
        int rank[] = new int[graph.length];

        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                if (union(rank, par, e.src, e.dest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }

}
