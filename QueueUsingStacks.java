import java.util.*;

public class QueueUsingStacks {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static void enqueue(int x) {
        s1.push(x);
    }

    static int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) return -1;
        return s2.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); 

        for (int i = 0; i < n; i++) {
            int type = input.nextInt();

            if (type == 1) {
                int x = input.nextInt();
                enqueue(x);
            } else { 
                System.out.println(dequeue());
            }
        }
        input.close();
    }
}