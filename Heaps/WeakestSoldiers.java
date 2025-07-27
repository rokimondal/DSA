import java.util.PriorityQueue;

public class WeakestSoldiers {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r) {
            if (this.soldiers == r.soldiers) {
                return this.idx - r.idx;
            }
            return this.soldiers - r.soldiers;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };

        int k=2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    count++;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R"+pq.remove().idx);
        }
    }
}
