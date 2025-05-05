import java.util.Stack;

public class DecodeString {
    public static String decodeString(String enStr) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < enStr.length(); i++) {
            char ch = enStr.charAt(i);
            if (ch != ']') {
                s.push(String.valueOf(ch));
            } else {
                String temp = "";
                while (!s.isEmpty() && !s.peek().equals("[")) {
                    temp = s.peek() + temp;
                    s.pop();
                }
                if (!s.isEmpty()) {
                    s.pop();
                }
                String n ="";
                while (!s.isEmpty() && Character.isDigit(s.peek().charAt(0))) {
                    n = s.peek()+n;
                    s.pop();
                }
                int num = Integer.parseInt(n);
                StringBuilder newStr = new StringBuilder("");
                while (num > 0) {
                    newStr.append(temp);
                    num--;
                }
                s.push(newStr.toString());
            }
        }

        StringBuilder result = new StringBuilder("");
        for (String t : s) {
            result.append(t);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String encodedString = "32[b2[v]]L";
        System.out.println(decodeString(encodedString));
    }
}
