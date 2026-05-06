import java.util.*;

public class CircularTour {

    public static int findStart(int[] petrol, int[] dist, int n) {
        int start = 0, deficit = 0, balance = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - dist[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] petrol = new int[n];
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            petrol[i] = input.nextInt();
            dist[i] = input.nextInt();
        }

        input.close();

        System.out.println(findStart(petrol, dist, n));
    }
}