public class FastExponent {
    public static void main(String[] args) {
        int a = 2;
        int n = 3;
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= a;
            }
            n = n >> 1;
            a = a * a;
        }
        System.out.println(ans);
    }
}
