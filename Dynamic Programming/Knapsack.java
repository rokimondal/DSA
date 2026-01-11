public class Knapsack {
    public static int knapsackRecursive(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsackRecursive(val, wt, W - wt[n - 1], n - 1);
            int ans2 = knapsackRecursive(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        }
        return knapsackRecursive(val, wt, W, n - 1);
    }

    public static int knapsackMemoization(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsackMemoization(val, wt, W - wt[n - 1], n - 1, dp);
            int ans2 = knapsackMemoization(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }

        dp[n][W] = knapsackMemoization(val, wt, W, n - 1, dp);
        return dp[n][W];
    }

    public static int knapsackTabulation(int val[], int wt[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < W + 1; i++) {
            dp[0][1] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(v + dp[i - 1][j - w], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < W + 1; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        return dp[n][W];
    }

    public static int unboundedKnapsackTabulation(int val[], int wt[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < W + 1; i++) {
            dp[0][1] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int n = 5;
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(unboundedKnapsackTabulation(val, wt, W, 5));
    }
}
