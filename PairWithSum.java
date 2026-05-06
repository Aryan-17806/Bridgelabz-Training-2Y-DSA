import java.util.*;

public class PairWithSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int target = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        input.close();

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: " + num + " " + (target - num));
                return;
            }
            set.add(num);
        }

        System.out.println("No pair found");
    }
}