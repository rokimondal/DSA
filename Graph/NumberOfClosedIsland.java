public class NumberOfClosedIsland {
    static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private static boolean dfs(int r, int c, int[][] grid, boolean[][] vis, int n, int m) {
        vis[r][c] = true;

        boolean isClosed = true;

        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                isClosed = false;
            } else if (grid[nr][nc] == 0 && !vis[nr][nc] && !dfs(nr, nc, grid, vis, n, m)) {
                isClosed = false;
            }
        }
        return isClosed;
    }

    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !vis[i][j] && dfs(i, j, grid, vis, n, m)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 }
        };
        System.out.println("Number of closed islands: " + closedIsland(grid));
    }
}
