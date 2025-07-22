public class AVL {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static int getBalance(Node root) {
        if (root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (root.data < key) {
            root.right = insert(root.right, key);
        } else if (root.data > key) {
            root.left = insert(root.left, key);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && root.left.data > key) {
            return rightRotate(root);
        }

        if (bf < -1 && root.right.data < key) {
            return leftRotate(root);
        }

        if (bf > 1 && root.left.data < key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && root.right.data > key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node getMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node deletNode(Node root, int key) {
        if (root == null)
            return root;

        if (root.data < key) {
            root.right = deletNode(root.right, key);
        } else if (root.data > key) {
            root.left = deletNode(root.left, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (root.left == temp) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = getMinNode(root.right);

                root.data = temp.data;

                root.right = deletNode(root.right, temp.data);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        if (bf < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        preorder(root);
        System.out.println();
        root = deletNode(root, 30);
        preorder(root);
        System.out.println();
    }
}
