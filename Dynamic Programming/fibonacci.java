public class fibonacci {

    public static int fiboMemoiztion(int n, int f[]) { // TopDown
        if (n == 0 || n == 1)
            return n;

        if (f[n] == 0)
            f[n] = fiboMemoiztion(n - 1, f) + fiboMemoiztion(n - 2, f);

        return f[n];
    }

    public static int fiboTabulation(int n) { // BottomUp
        int dp[] = new int[n + 1];

        // initialization
        dp[1] = 1;

        // filling
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;
        int f[] = new int[n + 1];
        System.out.println(fiboTabulation(n));
    }
}