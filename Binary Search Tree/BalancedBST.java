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

    public static Node createBalancedBinaryTree(List<Integer> data, int st, int ed) {
        if (st > ed) {
            return null;
        }

        int mid = st + (ed - st) / 2;

        Node root = new Node(data.get(mid));
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
        return createBalancedBinaryTree(sortedArray, 0, sortedArray.length - 1);

    }

    public static Node mergeBST(Node root1, Node root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        List<Integer> newSeq = new ArrayList<>();
        inOrder(root1, seq1);
        inOrder(root2, seq2);

        int i = 0, j = 0, k = 0;

        while (i < seq1.size() && j < seq2.size()) {
            if (seq1.get(i) < seq2.get(j)) {
                newSeq.add(seq1.get(i));
                i++;
            } else {
                newSeq.add(seq2.get(j));
                j++;
            }
        }

        while (i < seq1.size()) {
            newSeq.add(seq1.get(i));
            i++;
        }

        while (j < seq2.size()) {
            newSeq.add(seq2.get(j));
            j++;
        }

        return createBalancedBinaryTree(newSeq, 0, newSeq.size() - 1);
    }

    public static void main(String[] args) {
        // int values[] = { 8, 6, 5, 3, 10, 11, 12 };
        // Node root = null;
        // for (int value : values) {
        // root = insert(root, value);
        // }
        // inOrder(root);
        // System.out.println();
        // System.out.println(root.left.data);
        // root = convertBSTtoBalancedBST(root);
        // inOrder(root);
        // System.out.println();
        // System.out.println(root.left.data);
        int values1[] = { 1, 2, 4 };
        int values2[] = { 3, 9, 12 };
        Node root1 = createBalancedBinaryTree(values1, 0, values1.length - 1);
        Node root2 = createBalancedBinaryTree(values2, 0, values2.length - 1);
        Node newRoot = mergeBST(root1, root2);
        inOrder(newRoot);
    }
}