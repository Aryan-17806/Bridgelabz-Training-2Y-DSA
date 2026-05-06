import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BSTExample {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static boolean search(Node root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
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

        int searchKey = input.nextInt();
        input.close();

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println("\nFound: " + search(root, searchKey));
    }
}