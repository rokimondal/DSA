public class MaximumBalanceStringPartitions {
    public static int maxPartitions(String str) {
        int n = str.length();
        System.out.println(n);
        if (n == 0)
            return 0;
        int r = 0, l = 0, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }
            if (r == l) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxPartitions("LRRRRLLRLLRL"));
    }
}
