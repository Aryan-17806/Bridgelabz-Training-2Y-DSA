import java.util.*;

public class ExpressionTree {

    static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String postfix = input.next();

        input.close();

        System.out.println("Result: " + evaluatePostfix(postfix));
    }
}