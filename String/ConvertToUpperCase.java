public class ConvertToUpperCase {
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hlw, i am Roki";
        System.out.println(toUpperCase(str));
    }
}
