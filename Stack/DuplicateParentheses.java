import java.util.Stack;

public class DuplicateParentheses {
    public static boolean validParantheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ')') {
                s.push(ch);
            } else {
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1)
                    return true;
                s.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(((a+b)+(c+d)))";
        System.out.println(validParantheses(str));
    }
}
