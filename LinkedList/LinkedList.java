public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (this.head == null) {
            this.head = this.tail = newNode;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx > size) {
            System.out.println("You entered wrong index");
            return;
        }
        if (idx == 0) {
            addFirst(data);
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail)
            tail = temp.next;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linklist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linklist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key)
                return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recursiveSearch(Node head, int key) {
        if (head == null)
            return -1;
        if (head.data == key)
            return 0;
        int idx = recursiveSearch(head.next, key);
        if (idx == -1)
            return -1;
        return idx + 1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        if (size == n) {
            head = head.next;
            return;
        }

        Node prev = head;
        int i = 1;
        while (i < size - n) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public Node findMid() { // slow fast techniqe
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null)
            return true;
        // find mid
        Node mid = findMid();
        // reverse 2nd half linklist
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        // comparing both half
        while (right != null) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle() { // floyd's cycle finding algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public void createCycle(int idx) {
        Node temp = head;
        for (int i = 0; i <= idx; i++) {
            temp = temp.next;
        }
        tail.next = temp;
    }

    public void removeCycle() {
        if (head == null || head.next == null)
            return;
        Node slow = head;
        Node fast = head;
        Node prev = null;
        // detect cycle
        while (fast != null && fast != null) {
            slow = slow.next;
            prev = fast;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return;
        // find meeting point
        slow = head;
        while (slow != head) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        // remove cycle
        prev.next = null;
    }

    public Node getMid(Node head) { // slow fast techniqe
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // left & right ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);

    }

    public Node merge(Node left, Node right) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }

        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }
        return mergeLL.next;
    }

    public void zigzag() {
        // find mid (last of 1st half)
        Node mid = getMid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // conversion
        Node rightHead = prev;
        Node leftHead = head;
        Node nextL, nextR;

        while (leftHead != null && rightHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;
            leftHead = nextL;
            rightHead = nextR;
        }

    }

    public void deleteNAfterM(int M, int N) {
        if (M == 0) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp != null) {
            // skip M nodes
            Node prev = temp;
            for (int i = 1; i < M && prev.next != null; i++) {
                prev = prev.next;
            }

            // traverse N nodes
            Node next = prev.next;
            for (int i = 0; i < N && next != null; i++) {
                next = next.next;
            }
            prev.next = next;
            temp = next;
        }
    }

    public void oddEvenLinkedListByValue() {
        if (head == null || head.next == null)
            return;
        Node oddHead = new Node(-1);
        Node odd = oddHead;
        Node evenHead = new Node(-1);
        Node even = evenHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        odd.next = evenHead.next;
        even.next = null;
        head = oddHead.next;
    }

    public void oddEvenLinkedListByPosition() {
        if (head == null || head.next == null)
            return;
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return;
    }

    public void swappingNodes(int x, int y) {
        if (head == null || head.next == null)
            return;

        Node prev = null;
        Node temp = head;
        Node prevX = null;
        Node nodeX = null;
        Node prevY = null;
        Node nodeY = null;
        while (temp != null) {
            if (temp.data == x) {
                prevX = prev;
                nodeX = temp;
            }
            if (temp.data == y) {
                prevY = prev;
                nodeY = temp;
            }
            prev=temp;
            temp=temp.next;
        }

        if (nodeX == null || nodeY == null || nodeX == nodeY)
            return;
        
        if(prevX!=null){
            prevX.next=nodeY;
        }else{
            head=nodeY;
        }

        if(prevY!=null){
            prevY.next=nodeX;
        }else{
            head=nodeX;
        }
        temp=nodeX.next;
        nodeX.next=nodeY.next;
        nodeY.next=temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(6);
        list.addFirst(1);
        // list.addLast(8);
        list.addLast(3);
        list.addLast(4);
        list.add(4, 5);
        list.add(2, 7);
        list.add(4, 2);
        // list.print();
        // list.removeFirst();
        // list.removeLast();
        // System.out.println(list.iterativeSearch(9));
        // System.out.println(list.recursiveSearch(list.head,3));
        // list.reverse();
        // list.deleteNthFromEnd(3);
        // System.out.println(list.checkPalindrome());
        // list.createCycle(2);
        // System.out.println(list.isCycle());
        // list.removeCycle();
        // System.out.println(list.isCycle());
        // list.print();
        list.head = list.mergeSort(list.head);
        // list.print();
        // list.zigzag();
        list.print();
        // list.deleteNAfterM(0, 5);
        // list.oddEvenLinkedListByValue();
        list.swappingNodes(1, 8);
        list.print();
    }
}