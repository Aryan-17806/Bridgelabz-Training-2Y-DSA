import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BSTOperations {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node minNode = findMin(root.right);
            root.data = minNode.data;
            root.right = delete(root.right, minNode.data);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, input.nextInt());
        }

        int deleteVal = input.nextInt();
        root = delete(root, deleteVal);

        int insertVal = input.nextInt();
        root = insert(root, insertVal);

        input.close();

        inorder(root);
    }
}