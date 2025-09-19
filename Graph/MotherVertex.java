import java.util.ArrayList;
import java.util.Arrays;

public class MotherVertex {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int curr) {
        vis[curr] = true;
        for (int dest : adj.get(curr)) {
            if (!vis[dest]) {
                dfs(adj, vis, dest);
            }
        }
    }

    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V];
        int motherVertex = -1;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
                motherVertex = i;
            }
        }

        Arrays.fill(vis, false);

        dfs(adj, vis, motherVertex);

        for (boolean v : vis) {
            if (!v)
                return -1;
        }
        return motherVertex;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(2);
        adj.get(0).add(3);

        adj.get(1).add(0);

        adj.get(2).add(1);

        adj.get(3).add(4);

        System.out.println(findMotherVertex(V, adj));

    }
}
