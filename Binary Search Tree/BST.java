import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        if (val < root.data) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }

            Node successor = inorderSuccessor(root.right);

            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printallPath(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
            path.remove(path.size() - 1);
            return;
        }
        printallPath(root.left, path);
        printallPath(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.data <= min.data) || (max != null && root.data >= max.data)) {
            return false;
        }
        return isValid(root.left, min, root)
                && isValid(root.right, root, max);
    }

    public static Node mirrorBST(Node root) {
        if (root == null)
            return null;
        Node lefts = mirrorBST(root.left);
        Node rights = mirrorBST(root.right);
        // Node temp = root.left;
        root.left = rights;
        root.right = lefts;
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        // inorder(root);
        // System.out.println(search(root, 2));
        // System.out.println();
        // root = delete(root, 5);
        // inorder(root);
        // printInRange(root, 5, 12);
        // List<Integer> path = new ArrayList<>();
        // printallPath(root, path);
        // System.out.println(isValid(root, null, null));
        mirrorBST(root);
        inorder(root);
    }
}