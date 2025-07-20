import java.util.*;

public class BalancedBST {
    static class Node {
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

    public static Node createBalancedBinaryTree(int[] data, int st, int ed) {
        if (st > ed) {
            return null;
        }

        int mid = st + (ed - st) / 2;

        Node root = new Node(data[mid]);
        root.left = createBalancedBinaryTree(data, st, mid - 1);
        root.right = createBalancedBinaryTree(data, mid + 1, ed);
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void inOrder(Node root, List<Integer> ans) {
        if (root == null)
            return;

        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    public static Node convertBSTtoBalancedBST(Node root) {
        List<Integer> inorderSequence = new ArrayList<>();
        inOrder(root, inorderSequence);
        int[] sortedArray = new int[inorderSequence.size()];
        for (int i = 0; i < inorderSequence.size(); i++) {
            sortedArray[i] = inorderSequence.get(i);
        }
        return createBalancedBinaryTree(sortedArray, 0, sortedArray.length-1);

    }

    public static void main(String[] args) {
        int values[] = { 8, 6, 5, 3, 10, 11, 12 };
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        inOrder(root);
        System.out.println();
        System.out.println(root.left.data);
        root = convertBSTtoBalancedBST(root);
        inOrder(root);
        System.out.println();
        System.out.println(root.left.data);
    }
}