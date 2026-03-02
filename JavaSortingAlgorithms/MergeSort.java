import java.util.*;

public class MergeSort {
    public static void printArr(int[] arr){
        for(int i = 0 ; i < arr.length ;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = input.nextInt();
        input.close();
        divide(arr);
        printArr(arr);
    }
    public static void divide(int [] arr){
        int n = arr.length;
        if(n == 1) return;
        int [] a = new int[n/2];
        int [] b = new int [n-n/2];
        for(int i = 0 ; i < a.length ; i++) a[i] = arr[i];
        for(int i = 0 ; i < b.length ; i++) b[i] = arr[n/2+i];
        divide(a);
        divide(b);
        merge(arr,a,b);
        a = null;b = null;
    }
    public static void merge(int [] arr , int [] a , int [] b){
        int i = 0 , j = 0 , k = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]) arr[k++] = a[i++];
            else arr[k++] = b[j++];
        }
        while(i < a.length) arr[k++] = a[i++];
        while(j < b.length) arr[k++] = b[j++];

    }
}
