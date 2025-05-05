public class PrintNumbersInDecreasingOrder {
    public static void printDec(int n) {
        System.out.print(n + " ");
        if (n == 1) {
            return;
        }
        printDec(n - 1);
    }

    public static void main(String[] args) {
        printDec(10);
    }
}