public class CoinChange {
    public static int coinChange(int coins[], int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.err.println();
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int amount = 10;

        System.out.println(coinChange(coins, amount));
    }
}
