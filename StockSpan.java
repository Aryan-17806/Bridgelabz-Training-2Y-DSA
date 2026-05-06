import java.util.*;

public class StockSpan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] price = new int[n];
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = input.nextInt();
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            if (st.isEmpty()) span[i] = i + 1;
            else span[i] = i - st.peek();

            st.push(i);
        }

        input.close();

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}