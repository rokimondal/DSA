public class StringCompression {
    public static String stringCompressor(String str) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i < str.length()) {
            sb.append(str.charAt(i));
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            if (count > 1) {
                sb.append(count);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaaaaabbccccdddmmhhhhhlllde";
        System.out.println(stringCompressor(str));
    }
}
