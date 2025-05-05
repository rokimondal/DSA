import java.util.ArrayList;

public class BeautifulArray {

    public int[] beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();

            // Add odd numbers: 2*x - 1
            for (int x : result) {
                int val = 2 * x - 1;
                if (val <= n) {
                    temp.add(val);
                }
            }

            // Add even numbers: 2*x
            for (int x : result) {
                int val = 2 * x;
                if (val <= n) {
                    temp.add(val);
                }
            }

            result = temp;
        }

        // Convert ArrayList<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    // Main method to test
    public static void main(String[] args) {
        BeautifulArray ba = new BeautifulArray();
        int n = 5;

        int[] result = ba.beautifulArray(n);
        System.out.print("Beautiful array for n = " + n + " is: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
