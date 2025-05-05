import java.util.HashMap;
import java.util.Map;

//solve in leetcode and this is converted by gpt
public class MostFreqNumber {

    public int mostFrequent(int[] nums, int key) {
        int n = nums.length;
        HashMap<Integer, Integer> targets = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                targets.put(nums[i + 1], targets.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int maxInd = -1;

        for (Map.Entry<Integer, Integer> entry : targets.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxInd = entry.getKey();
            }
        }

        return maxInd;
    }

    // Main method to test
    public static void main(String[] args) {
        MostFreqNumber obj = new MostFreqNumber();

        int[] nums = { 1, 100, 200, 1, 100 };
        int key = 1;

        int result = obj.mostFrequent(nums, key);
        System.out.println("Most frequent number after key = " + key + " is: " + result);
    }
}
