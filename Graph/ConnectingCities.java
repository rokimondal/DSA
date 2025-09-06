import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities {
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static int minCost(int cities[][]) {

        boolean vis[] = new boolean[cities.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                cost += curr.cost;
                for (int i = 0; i < cities[curr.v].length; i++) {
                    if (cities[curr.v][i] != 0) {
                        pq.add(new Pair(i, cities[curr.v][i]));
                    }
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int cities[][] = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        System.out.println(minCost(cities));
    }
}
