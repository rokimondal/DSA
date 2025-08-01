import java.util.*;

import javax.swing.tree.TreeNode;

public class OperationOfBinaryTree {
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

    public static boolean isuniValued(Node root, int n) {
        if (root == null) {
            return true;
        }
        if (root.data != n) {
            return false;
        }
        return isuniValued(root.left, n) && isuniValued(root.right, n);
    }

    public static void invertBinaryTree(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    public static Node deleteLeaf(Node root, int n) {
        if (root == null) {
            return null;
        }
        Node leftNode = deleteLeaf(root.left, n);
        Node rightNode = deleteLeaf(root.right, n);

        if (leftNode == null) {
            root.left = null;
        }

        if (rightNode == null) {
            root.right = null;
        }

        if (leftNode == null && rightNode == null && root.data == n) {
            root.data = -1;
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        int preorder[] = { 1, 5, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // int preorder[] = { 1, 1, 1, -1, -1, 1, -1, -1, 1, -1, 1, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(preorder);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        tree.BFS(root);
        System.out.println();
        // System.out.println(tree.height(root));
        // System.out.println(tree.count(root));
        // System.out.println(tree.sumOfAllNodes(root));
        // System.out.println(isuniValued(root, root.data));
        // invertBinaryTree(root);
        deleteLeaf(root, 5);
        tree.BFS(root);
        System.out.println();
    }
}
