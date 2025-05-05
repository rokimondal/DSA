import java.util.Stack;

public class ValidParantheses {
    public static boolean validParantheses(char arr[]) {
        Stack<Character> s = new Stack<>();
        for (char ch : arr) {
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.empty())
                    return false;
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}' || (s.peek() == '['
                        && ch == ']'))) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        char arr[] = { '(', '{', '[', ']', '}', '[', ']', ')' };
        System.out.println(validParantheses(arr));
    }
}
