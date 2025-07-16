import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinDistance {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(Node left, int data) {
            this.data = data;
            this.left = left;
            this.right = null;
        }

        Node(int data, Node right) {
            this.data = data;
            this.left = null;
            this.right = right;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildBinaryTree(int preorder[]) {
            idx++;
            if (preorder[idx] == -1)
                return null;

            Node newNode = new Node(preorder[idx]);

            newNode.left = buildBinaryTree(preorder);
            newNode.right = buildBinaryTree(preorder);

            return newNode;
        }

        void preOrder(Node root) {
            if (root == null)
                return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        void inOrder(Node root) {
            if (root == null)
                return;
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        void postOrder(Node root) {
            if (root == null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        void BFS(Node root) {
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while (q.size() > 0) {
                Node curr = q.peek();
                q.remove();
                if (curr == null) {
                    if (!q.isEmpty()) {
                        System.out.println();
                        q.add(null);
                    } else {
                        break;
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        int height(Node root) {
            if (root == null)
                return 0;
            return (Math.max(height(root.left), height(root.right)) + 1);
        }

        int count(Node root) {
            if (root == null)
                return 0;
            return (count(root.left) + count(root.right) + 1);
        }

        int sumOfAllNodes(Node root) {
            if (root == null)
                return 0;
            return (sumOfAllNodes(root.left) + sumOfAllNodes(root.right) + root.data);
        }
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        if (rightlca == null) {
            return leftlca;
        }

        if (leftlca == null) {
            return rightlca;
        }

        return root;
    }

    public static int dist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftdist = dist(root.left, n);
        int rightdist = dist(root.right, n);

        if (leftdist > -1) {
            return leftdist + 1;
        }

        if (rightdist > -1) {
            return rightdist + 1;
        }

        return -1;
    }

    public static int minDist(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        Node lca = lca2(root, n1, n2);
        return dist(lca, n1) + dist(lca, n2);
    }

    public static void main(String[] args) {
        int preorder[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(preorder);
        System.out.println(minDist(root, 4, 6));
    }
}
