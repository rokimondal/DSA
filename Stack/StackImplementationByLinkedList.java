public class StackImplementationByLinkedList {
    public static class Stack {
        private class Node {
            int data;
            Node next;
            Node(int data){
                this.data=data;
                next=null;
            }
        }
        Node head =null;

        //isEmpty
        public boolean isEmpty(){
            return head==null;
        }

        //peak
        public int peak(){
            if(isEmpty()) return -1;
            return head.data;
        }

        //push
        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        //pop
        public int pop(){
            if(isEmpty()) return -1;
            int top = head.data;
            head=head.next;
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
