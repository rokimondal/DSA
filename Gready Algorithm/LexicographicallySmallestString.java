import java.util.Arrays;

public class LexicographicallySmallestString {
    public static String smallestString(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');

        for (int i = n - 1; i >= 0; i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    arr[i] = (char) ('a' + k - 1);
                    k -= (arr[i] - 'a' + 1);
                }
            } else {
                break;
            }
            k += i;
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(smallestString(5, 42));
    }
}
