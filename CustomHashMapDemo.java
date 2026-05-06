import java.util.*;

class MyHashMap {

    static class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] bucket;
    private int size;

    MyHashMap(int size) {
        this.size = size;
        bucket = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    void put(int key, int value) {
        int idx = hash(key);
        Node head = bucket[idx];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = bucket[idx];
        bucket[idx] = newNode;
    }

    int get(int key) {
        int idx = hash(key);
        Node head = bucket[idx];

        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return -1;
    }

    void remove(int key) {
        int idx = hash(key);
        Node head = bucket[idx], prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null)
                    bucket[idx] = head.next;
                else
                    prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}

public class CustomHashMapDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        MyHashMap map = new MyHashMap(10);

        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int key = input.nextInt();
            int value = input.nextInt();
            map.put(key, value);
        }

        int searchKey = input.nextInt();
        input.close();

        System.out.println("Value: " + map.get(searchKey));
    }
}