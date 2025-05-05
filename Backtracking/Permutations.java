public class Permutations {
    public static void permutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
        }
        for (int i = 0; i < str.length(); i++) {
            permutations(str.substring(0, i) + str.substring(i + 1), ans + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        permutations("abc", "");
    }
}
