public class CatalanNumber {
    public static int catalan(int n) {
        if (n == 0 || n == 1)
            return 1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalan(i) * catalan(n - i - 1);
        }

        return ans;
    }

    public static int catalanMemoization(int n, int dp[]) {
        if (n == 0 || n == 1) {
            dp[n] = 1;
            return dp[n];
        }
        if (dp[n] != 0)
            return dp[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMemoization(i, dp) * catalanMemoization(n - i - 1, dp);
        }
        dp[n] = ans;
        return dp[n];
    }

    public static int catalanTabulation(int n) {
        if (n == 0 || n == 1)
            return 1;

        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 20;
        int dp[] = new int[n + 1];
        System.out.println(catalanTabulation(n));
    }
}
