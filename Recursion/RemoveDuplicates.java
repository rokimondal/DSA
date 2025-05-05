public class RemoveDuplicates {
    public static void removeDuplicates(String str, StringBuilder newStr, int idx, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        if (!map[str.charAt(idx) - 'a']) {
            newStr.append(str.charAt(idx));
            map[str.charAt(idx) - 'a'] = true;
        }
        removeDuplicates(str, newStr, idx + 1, map);
    }

    public static void main(String[] args) {
        String str = "aaaapnaaacollege";
        removeDuplicates(str, new StringBuilder(), 0, new boolean[26]);
    }
}
