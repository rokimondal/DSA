public class ImplementationUsingLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static class Queue {
        Node front;
        Node rear;

        Queue() {
            front = null;
            rear = null;
        }

        public boolean isEmpty() {
            return front == null && rear == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = rear.next;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            if(rear==front){
                rear=null;
            }
            int data = front.data;
            front=front.next;
            return data;
        }
        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
