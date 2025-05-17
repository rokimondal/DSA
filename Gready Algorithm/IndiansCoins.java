import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndiansCoins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000 };

        Arrays.sort(coins, Comparator.reverseOrder());

        int amount = 590;
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            while (amount >= coins[i]) {
                count++;
                ans.add(coins[i]);
                amount = amount - coins[i];
            }
        }
        System.out.println(count);
        System.out.println(ans);
    }
}
