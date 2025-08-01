import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        int hi;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int hd;
        Node node;

        Info(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void BottomView(Node root) {
        if (root == null)
            return;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        q.add(null);

        int min = 0;
        int max = 0;

        HashMap<Integer, Node> map = new HashMap<>();
        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                } else {
                    break;
                }
            } else {
                map.put(curr.hd, curr.node);

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        // inorder(root);
        // System.out.println();
        // preorder(root);

        BottomView(root);
    }
}
