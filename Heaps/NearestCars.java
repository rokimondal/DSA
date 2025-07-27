import java.util.PriorityQueue;

public class NearestCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p) {
            return this.dist - p.dist;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            pq.add(new Point(x, y, dist));
        }
        int n = k;
        int[][] ans = new int[n][2];
        while (n > 0) {
            Point p = pq.remove();
            ans[k - n][0] = p.x;
            ans[k - n][1] = p.y;
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int[][] ans = kClosest(points, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + ", " + ans[i][1]);
        }
    }
}
