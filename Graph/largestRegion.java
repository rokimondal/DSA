public class largestRegion {
    static int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    public static int dfs(int[][] grid, int r, int c, boolean vis[][]) {
        vis[r][c] = true;

        int len = 1;

        for (int i = 0; i < dir.length; i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1 && !vis[nr][nc]) {
                len += dfs(grid, nr, nc, vis);
            }
        }

        return len;
    }

    public static int maxregion(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxLen = 0;
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    maxLen = Math.max(maxLen, dfs(grid, i, j, vis));
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 0, 0, 1, 1, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };

        System.out.println(maxregion(grid));
    }
}
