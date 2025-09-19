import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PossibleToFinishAllTask {
    private static void createGraph(ArrayList<Integer>[] graph, int[][] prerequisites) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        createGraph(graph, prerequisites);
        int[] indegree = new int[numCourses];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                indegree[graph[i].get(j)]++;
            }
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            count++;
            for (int i = 0; i < graph[curr].size(); i++) {
                int dest = graph[curr].get(i);
                indegree[dest]--;
                if (indegree[dest] == 0) {
                    q.add(dest);
                }
            }
        }

        if (count != numCourses) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses3 = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(canFinish(numCourses3, prerequisites));
    }
}
