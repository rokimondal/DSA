public class CountSubStringStartAndEndSame {
    public static int CountSubstring(String str) {
        if (str.length() == 1) {
            return 1;
        }
        int count = 1;
        char firstChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (firstChar == str.charAt(i)) {
                count++;
            }
        }
        return count + CountSubstring(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "abcab";
        System.out.println(CountSubstring(str));
    }
}
