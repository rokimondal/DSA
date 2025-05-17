import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int values[] = { 60, 100, 120 };
        int weights[] = { 10, 20, 30 };
        int W = 50;
        
        double ratio[][] = new double[values.length][2];
        
        for (int i = 0; i < values.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = values[i] / (double) weights[i];
        }
        
        Arrays.sort(ratio, Comparator.comparing(o -> o[1]));
        int capacity = W;
        int totalValue = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            if (capacity >= weights[(int) ratio[i][0]]) {
                totalValue += values[(int) ratio[i][0]];
                capacity -= weights[(int) ratio[i][0]];
            } else {
                totalValue += ratio[i][1] * capacity;
                break;
            }
        }
        System.out.println(totalValue);
    }
}