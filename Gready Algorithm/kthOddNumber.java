public class kthOddNumber {
    public static int kthOdd(int[] range, int k) {
        if (k <= 0)
            return 0;

        int l = range[0];
        int r = range[1];
        int count = (int) Math.ceil((r - l + 1) / 2);
        if (count < k)
            return 0;
        if ((r & 1) > 0) {
            return r - 2 * k + 2;
        } else {
            return r - 2 * k + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(kthOdd(new int[] { -3, 3 }, 1));
    }
}
