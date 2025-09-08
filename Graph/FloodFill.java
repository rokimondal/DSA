import java.util.Arrays;

public class FloodFill {
    public static void helper(int image[][], int sr, int sc, boolean vis[][], int color, int orgColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        helper(image, sr, sc + 1, vis, color, orgColor);
        helper(image, sr, sc - 1, vis, color, orgColor);
        helper(image, sr - 1, sc, vis, color, orgColor);
        helper(image, sr + 1, sc, vis, color, orgColor);
    }

    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, vis, color, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int image[][] = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        int result[][] = floodFill(image, sr, sc, color);

        // Print result
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
