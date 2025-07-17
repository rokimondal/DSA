import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class DuplicateSubtree {
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

    private static String getSubTree(Node root, HashMap<String, Integer> map, List<Node> ans) {
        if (root == null)
            return "N";

        String s = root.data + "," + getSubTree(root.left, map, ans) + "," + getSubTree(root.right, map, ans);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            ans.add(root);
        }
        return s;
    }

    public static void findDuplicateSubtrees(Node root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Node> ans = new ArrayList<>();
        getSubTree(root, map, ans);
        for (Node ele : ans) {
            System.out.print(ele.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int preorder[] = { 1, 2, 4, -1, -1, -1, 3, 2, 4, -1, -1, -1, 4, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(preorder);
        findDuplicateSubtrees(root);
    }
}
