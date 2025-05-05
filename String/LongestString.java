public class LongestString {
    public static void main(String[] args) {
        String str[] = { "flower", "flow", "flight" };
        String longest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (longest.compareTo(str[i]) < 0) {
                longest = str[i];
            }
        }
        System.out.println(longest);
    }
}
