import java.util.ArrayList;

public class ArticulationPoint {
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

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

    }

    public static void dfs(ArrayList<Edge>[] graph, boolean vis[], int parent, int curr, int time, int dt[], int low[],
            boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (parent != e.dest) {
                if (!vis[e.dest]) {
                    dfs(graph, vis, curr, e.dest, time, dt, low, ap);
                    low[curr] = Math.min(low[curr], low[e.dest]);
                    if (parent != -1 && dt[curr] < low[e.dest]) {
                        ap[curr] = true;
                    }
                    children++;
                } else {
                    low[curr] = Math.min(low[curr], dt[e.dest]);
                }
            }
        }

        if (parent == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph, int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];
        int time = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, vis, -1, i, time, dt, low, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("Articulation Point : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        tarjanBridge(graph, v);
    }

}
