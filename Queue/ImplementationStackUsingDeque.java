import java.util.*;

public class ImplementationStackUsingDeque {
    public static class Stack {
        Deque<Integer> q = new LinkedList<>();

        public boolean isEmpty() {
            return q.isEmpty();
        }

        public void push(int data) {
            q.addLast(data);
        }

        public int pop() {
            return q.removeLast();
        }

        public int peek() {
            return q.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.push(4);
        s.pop();
        s.push(5);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
