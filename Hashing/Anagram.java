import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            if (e.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("race", "care"));
    }
}
