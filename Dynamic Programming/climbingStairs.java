import java.util.Arrays;

public class ClimbingStairs {

    public static int climbStairRecursion(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        return climbStairRecursion(n - 1) + climbStairRecursion(n - 2);
    }

    public static int climbStairMemoization(int n, int ways[]) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = climbStairRecursion(n - 1) + climbStairRecursion(n - 2);
        return ways[n];
    }

    public static int climbStairTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        // System.out.println(climbStairRecursion(5));
        int n = 5;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(climbStairTabulation(n));
    }
}