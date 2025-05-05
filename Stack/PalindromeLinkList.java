import java.util.LinkedList;
import java.util.Stack;

public class PalindromeLinkList {
    public static boolean isPalindrome(LinkedList<Character> list) {

        Stack<Character> s = new Stack<>();
        for (char ch : list) {
            s.push(ch);
        }

        for (int i = 0; i < list.size() && !s.isEmpty(); i++) {
            if (!list.get(i).equals(s.peek())) {
                return false;
            }
            s.pop();
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('B');
        list.add('A');
        System.out.println(isPalindrome(list));
    }
}
