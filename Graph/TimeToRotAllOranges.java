import java.util.LinkedList;
import java.util.Queue;

public class TimeToRotAllOranges {
    public static int orangeRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int minute = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            minute++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();

                for (int j = 0; j < dir.length; j++) {
                    int nr = curr[0] + dir[j][0];
                    int nc = curr[1] + dir[j][1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }

        return fresh == 0 ? minute : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 0, 2, 1 },
                { 0, 0, 1, 2, 1 },
                { 0, 0, 0, 2, 1 } };
        int time = orangeRotting(grid);

        if (time == -1) {
            System.out.println("All oranges cannot be rooten");
        } else {
            System.out.println("Time: " + time);
        }
    }
}
