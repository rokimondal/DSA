public class TillingProblem {
    public static int tillingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return tillingProblem(n - 1) + tillingProblem(n - 2);// for vertical choice tillingProblem(n - 1) and for horizontal choice tillingProblem(n - 2)
    }

    public static void main(String[] args) {
        System.out.println(tillingProblem(5));
    }
}
