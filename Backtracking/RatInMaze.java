public class RatInMaze {
    public static boolean solveMaze(int maze[][], int row, int col, int sol[][]) {
        if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 1) {
            sol[row][col] = 1;
            return true;
        }

        if (isSafe(maze, row, col)) {
            if (sol[row][col] == 1)
                return false;
            sol[row][col] = 1;
            if (solveMaze(maze, row + 1, col, sol))
                return true;// down
            if (solveMaze(maze, row, col + 1, sol))
                return true;// right
            if (solveMaze(maze, row, col - 1, sol))
                return true;// left
            if (solveMaze(maze, row - 1, col, sol))
                return true;// up
            sol[row][col] = 0;
        }
        return false;
    }

    public static boolean isSafe(int maze[][], int row, int col) {
        if (row < 0 || col < 0)
            return false;
        if (row < maze.length && col < maze.length && maze[row][col] == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        int maze[][] = {
                { 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1 },
                { 1, 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 1 },
                { 1, 1, 1, 1, 0, 1 },
        };
        int sol[][] = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
        };
        if (solveMaze(maze, 0, 0, sol)) {
            System.out.println("Solution is exist:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Solution is exist!");
        }
    }
}
