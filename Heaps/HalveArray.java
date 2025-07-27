import java.util.Comparator;
import java.util.PriorityQueue;

public class HalveArray {
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;

        for (int ele : nums) {
            sum += ele;
            pq.add((double) ele);
        }

        Double halfSum = sum / 2;
        int k = 0;
        Double reduced = 0.0;

        while (reduced < halfSum) {
            double halfMax = pq.remove() / 2;
            reduced += halfMax;
            pq.add(halfMax);
            k++;
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 19, 8, 1 };
        System.out.println(halveArray(nums));
    }
}
