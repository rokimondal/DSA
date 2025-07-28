import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MejorityElement {
    public static ArrayList<Integer> mejorityElements(int nums[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int ele : nums) {
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (Map.Entry<Integer, Integer> ele : hm.entrySet()) {
            if (ele.getValue() > n / 3) {
                ans.add(ele.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        System.out.println(mejorityElements(arr));
    }
}
