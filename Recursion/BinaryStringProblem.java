public class BinaryStringProblem {
    public static void printBinaryStrings(int lastDigit, int n, StringBuilder str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // if (lastDigit == 0) {
        // printBinaryStrings(0, n - 1, str.append("0"));
        // printBinaryStrings(1, n - 1, str.append("1"));
        // } else {
        // printBinaryStrings(0, n - 1, str.append("0"));
        // }
        printBinaryStrings(0, n - 1, new StringBuilder(str).append("0"));
        if (lastDigit == 0) {
            printBinaryStrings(1, n - 1, new StringBuilder(str).append("1"));
        }
    }

    public static void main(String[] args) {
        printBinaryStrings(0, 3, new StringBuilder(""));
    }
}