import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        Arrays.sort(pairs, Comparator.comparing(o -> o[1]));

        int chainLen = 1;
        int lastend = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastend) {
                chainLen++;
                lastend = pairs[i][1];
            }
        }
        System.out.println(chainLen);
    }
}
