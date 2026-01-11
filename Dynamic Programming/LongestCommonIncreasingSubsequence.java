import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonIncreasingSubsequence {

    public static int lis(int nums[]) {
        int n = nums.length;
        Set<Integer> temp = new HashSet<>();
        for (int e : nums) {
            temp.add(e);
        }
        int[] nums2 = new int[temp.size()];
        int m = 0;
        for (int e : temp) {
            nums2[m] = e;
            m++;
        }
        Arrays.sort(nums2);

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int nums[] = { 50, 3, 10, 7, 40, 80 };

        System.out.println(lis(nums));
    }
}
