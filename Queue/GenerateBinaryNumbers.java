import java.util.*;

public class GenerateBinaryNumbers {
    public static void printAllBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<>();

        q.add("1");
        for (int i = 0; i < n; i++) {
            String str = q.remove();
            System.out.println(str);
            q.add(str + "0");
            q.add(str + "1");
        }
    }

    public static void main(String[] args) {
        printAllBinaryNumbers(10);
    }
}