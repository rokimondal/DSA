import java.util.*;

public class ReversingTheFirstKElements {
    public static void reverseKElement(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        for (int i = 0; i < k; i++) {
            q.add(s.pop());
        }
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        reverseKElement(q, 5);
        System.out.println(q);
    }
}
