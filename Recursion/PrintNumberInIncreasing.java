public class PrintNumberInIncreasing {
    public static void printInc(int n) {
        if (n == 0) {
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        printInc(10);
    }
}
