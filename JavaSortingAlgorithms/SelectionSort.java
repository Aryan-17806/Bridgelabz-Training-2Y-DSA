import java.util.Scanner;

public class SelectionSort {
    public static void print(int[]  arr) {
        for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = input.nextInt();
        }


        for(int i = 0  ; i < n - 1; i ++){
            int min = Integer.MAX_VALUE;
            int minInd = -1;

                for(int j = i ; j < n  ; j++){
                if(min > arr[j]){
                min = arr[j];
                minInd = j;
                }
            }
                int temp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = temp;
        }


        print(arr);
        input.close();
    }
}
