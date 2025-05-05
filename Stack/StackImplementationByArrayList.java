import java.util.ArrayList;

public class StackImplementationByArrayList {
    public static class Stack {
        private static ArrayList<Integer> list = new ArrayList<>();

        // isEmpty()
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // peak
        public int peak() {
            if (isEmpty())
                return -1;
            return list.get(list.size() - 1);
        }

        // push
        public void push(int data) {
            list.add(data);
        }

        // pop
        public int pop() {
            if (isEmpty())
                return -1;
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }
}