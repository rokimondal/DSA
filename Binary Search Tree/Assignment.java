import java.util.*;

public class Assignment {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int minDiffNode(Node root, int k) {
        if (root == null)
            return -1;

        int closest = root.data;
        while (root != null) {
            if (Math.abs(closest - k) > Math.abs(root.data - k)) {
                closest = root.data;
            }

            if (root.data > k) {
                root = root.left;
            } else if (root.data < k) {
                root = root.right;
            } else {
                break;
            }
        }
        return Math.abs(closest - k);
    }

    static class pair {
        int val1, val2;

        pair(int a, int b) {
            this.val1 = a;
            this.val2 = b;
        }
    }

    public static void inOrder(Node root, HashSet<Integer> set) {
        if (root == null) {
            return;
        }
        inOrder(root.left, set);
        set.add(root.data);
        inOrder(root.right, set);
    }

    public static void findPairs(Node root, int key, HashSet<Integer> set, List<pair> ans) {
        if (root == null)
            return;
        if (set.contains(key - root.data)) {
            ans.add(new pair(key, root.data));
        }
        findPairs(root.left, key, set, ans);
        findPairs(root.right, key, set, ans);
    }

    public static List<pair> findTarget(Node root1, Node root2, int k) {
        List<pair> ans = new ArrayList<pair>();
        if (root1 == null || root2 == null) {
            return new ArrayList<pair>();
        }

        HashSet<Integer> set = new HashSet<>();
        inOrder(root2, set);
        findPairs(root1, k, set, ans);
        return ans;
    }

    public static void main(String[] args) {
        Node root1 = new Node(9);
        root1.left = new Node(4);
        root1.right = new Node(17);
        root1.left.left = new Node(3);
        root1.left.right = new Node(6);
        root1.left.right.left = new Node(5);
        root1.left.right.right = new Node(7);
        root1.right.right = new Node(22);
        root1.right.right.left = new Node(20);

        int k = 18;

        // ✅ 1. Test minDiffNode
        System.out.println("Minimum absolute difference with " + k + ": " + minDiffNode(root1, k));

        // Second BST (root2)
        Node root2 = new Node(8);
        root2.left = new Node(2);
        root2.right = new Node(10);
        root2.left.left = new Node(1);
        root2.left.right = new Node(3);
        root2.right.right = new Node(12);

        // ✅ 2. Test findTarget
        List<pair> result = findTarget(root1, root2, k);

        System.out.println("Pairs from both BSTs that sum to " + k + ":");
        for (pair p : result) {
            System.out.println("(" + (k - p.val2) + ", " + p.val2 + ")");
        }
    }
}
