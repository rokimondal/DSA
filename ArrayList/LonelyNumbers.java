import java.util.ArrayList;
import java.util.List;

public class LonelyNumbers {
    public static List<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int count = 0;
            for (int n : nums) {
                if (n == num)
                    count++;
            }
            if (count == 1 && !nums.contains(num - 1) && !nums.contains(num + 1)) {
                ans.add(num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        List<Integer> result = findLonely(nums);
        System.out.println("Lonely numbers: " + result);
    }
}
