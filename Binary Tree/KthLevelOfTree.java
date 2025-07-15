import java.util.*;

public class KthLevelOfTree {
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

    public static void kthLevelIterative(Node root, int k) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;

        while (q.size() > 0) {
            Node curr = q.peek();
            q.remove();
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    level++;
                } else {
                    break;
                }
            } else {
                if (level == k) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        System.out.println();
    }

    public static void kthLevelRecursive(Node root, int level, int k) {
        if(root==null){
            return;
        }

        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        kthLevelRecursive(root.left, level+1, k);
        kthLevelRecursive(root.right, level+1, k);
    }

    public static void main(String[] args) {
        int preorder[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(preorder);
        kthLevelIterative(root, 3);
        kthLevelRecursive(root, 1, 3);
        System.out.println();

    }
}
