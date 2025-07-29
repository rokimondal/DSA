import java.util.HashMap;

public class SubArraySumEqualsToK {
    public static void main(String[] args) {
        int nums[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
