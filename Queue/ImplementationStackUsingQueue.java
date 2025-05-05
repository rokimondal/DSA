import java.util.*;

public class ImplementationStackUsingQueue {
    // public static class Queue {
    // Stack<Integer> s1 = new Stack<>();
    // Stack<Integer> s2 = new Stack<>();

    // public boolean isEmpty() {
    // return s1.isEmpty();
    // }

    // public void add(int data) { //o(n)
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }
    // s1.push(data);
    // while (!s2.isEmpty()) {
    // s1.push(s2.pop());
    // }
    // }

    // public int remove() { O(1)
    // if (isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }
    // return s1.pop();
    // }

    // public int peek() {
    // if (isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }
    // return s1.peek();
    // }
    // }

    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {// O(1)
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {// O(n)
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek() { // O(n)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int top=-1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
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