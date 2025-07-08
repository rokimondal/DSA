import java.util.*;

public class SpilitIntoKSubarrays {

    static class Solution {
        private boolean canSplit(int[] nums, int k, int maxSum) {
            int count = 1, currSum = 0;
            for (int num : nums) {
                currSum += num;
                if (currSum > maxSum) {
                    count++;
                    currSum = num;
                    if (count > k)
                        return false;
                }
            }
            return true;
        }

        public int splitArray(int[] nums, int k) {
            int l = 0, r = 0;
            for (int num : nums) {
                l = Math.max(l, num);
                r += num;
            }

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (canSplit(nums, k, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = { 1, 1, 2 }; // Sample input
        int k = 2;

        int result = sol.splitArray(nums, k);
        System.out.println("Minimum largest subarray sum: " + result); // Output: 2
    }
}
