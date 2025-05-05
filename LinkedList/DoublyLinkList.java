public class DoublyLinkList {
    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else if (head.next == null) {
            int data = head.data;
            size--;
            head = tail = null;
            return data;
        }
        int data = head.data;
        size--;
        head = head.next;
        head.prev = null;
        return data;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else if (head.next == null) {
            int data = head.data;
            size--;
            head = tail = null;
            return data;
        }
        int data = tail.data;
        size--;
        tail = tail.prev;
        tail.next = null;
        return data;
    }

    public void print() {
        Node temp = head;
        System.out.print("null<->");
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    
    public void reverse() {
        Node curr = head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkList list = new DoublyLinkList();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        // list.print();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        // list.print();
        list.removeFirst();
        // list.print();
        list.removeLast();
        list.print();
        list.reverse();
        list.print();
    }
}
