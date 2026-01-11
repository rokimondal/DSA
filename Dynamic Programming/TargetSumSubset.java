public class TargetSumSubset {

    public static boolean sumTabulation(int val[], int targetSum) {
        int n = val.length;
        boolean dp[][] = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < targetSum + 1; i++) {// we can skip because java by default store false value
            dp[0][i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                int v = val[i - 1];
                if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                }
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        // for (int i = 0; i < n + 1; i++) {
        //     for (int j = 0; j < targetSum + 1; j++) {
        //         if(dp[i][j]) 
        //             System.out.print("T ");
        //         else 
        //             System.out.print("F ");
        //     }
        //     System.out.println();
        // }

        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        int n = 5;
        int val[] = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        System.out.println(sumTabulation(val, targetSum));
    }
}
