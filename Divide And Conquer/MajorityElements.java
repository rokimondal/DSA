public class MajorityElements {
    public static int majorityElementOptimized(int[] nums) { // optimized O(n)
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public static int countInRange(int arr[], int num, int lo, int hi) { // O(nlogn)
        int count = 0;
        for (int i = lo; i <= hi; i++)
            if (arr[i] == num)
                count++;
        return count;
    }

    public static int majorityElement(int nums[], int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = lo + ((hi - lo) / 2);
        int left = majorityElement(nums, lo, mid);
        int right = majorityElement(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums, 0, nums.length - 1));
    }
}
