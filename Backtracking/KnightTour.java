public class KnightTour {
    public static boolean isValid(int[][] grid, int row, int col, int n, int expValue) {
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != expValue)
            return false;
        if (expValue == ((n * n) - 1))
            return true;
        if (isValid(grid, row - 2, col + 1, n, expValue + 1))
            return true;
        if (isValid(grid, row - 1, col + 2, n, expValue + 1))
            return true;
        if (isValid(grid, row + 1, col + 2, n, expValue + 1))
            return true;
        if (isValid(grid, row + 2, col + 1, n, expValue + 1))
            return true;
        if (isValid(grid, row + 2, col - 1, n, expValue + 1))
            return true;
        if (isValid(grid, row + 1, col - 2, n, expValue + 1))
            return true;
        if (isValid(grid, row - 1, col - 2, n, expValue + 1))
            return true;
        if (isValid(grid, row - 2, col - 1, n, expValue + 1))
            return true;

        return false;
    }

    public static boolean knightTour(int[][] grid, int row, int col, int[] dr, int[] dc, int n, int nextValue) {
        if (nextValue == n * n)
            return true;

        int nextRow, nextCol;

        for (int i = 0; i < 8; i++) {
            nextRow = row + dr[i];
            nextCol = col + dc[i];
            if (isSafe(grid, nextRow, nextCol, n)) {
                grid[nextRow][nextCol] = nextValue;
                if (knightTour(grid, nextRow, nextCol, dr, dc, n, nextValue + 1)) {
                    return true;
                }
                grid[nextRow][nextCol] = -1;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] grid, int row, int col, int n) {
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != -1)
            return false;
        return true;
    }

    public static void printGrid(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        int dr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        grid[0][0] = 0;
        if (knightTour(grid, 0, 0, dr, dc, n, 1)) {
            System.out.println("Solution is exist");
            printGrid(grid);
        } else {
            System.out.println("Solution is not exist");
        }
    }
}
