import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUssingBFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

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

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        int par[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                par[i] = -1;
                if (isCycleUtill(graph, vis, i, par)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtill(ArrayList<Edge> graph[], boolean vis[], int curr, int par[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while (!q.isEmpty()) {
            curr = q.remove();
            vis[curr]=true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (vis[e.dest]) {
                    if (par[curr] != e.dest) {
                        return true;
                    }
                } else {
                    par[e.dest] = curr;
                    q.add(e.dest);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
