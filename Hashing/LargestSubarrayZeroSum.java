import java.util.HashMap;

public class LargestSubarrayZeroSum {
    public static void main(String[] args) {
        int nums[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(len);
    }

}
