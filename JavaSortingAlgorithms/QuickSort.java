import java.util.Scanner;

public class QuickSort {
    public static void print(int [] arr){
        for(int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");
    }
    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = input.nextInt();
        }
        input.close();
        Sort(arr,0,n-1);
        print(arr);
    }
    public static void Sort(int [] arr,int low ,int high){
        if(low < high){
            int piv = partition(arr, low, high);
            Sort(arr,low,piv-1);
            Sort(arr,piv+1,high);
        }
    }
    public static int partition(int [] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low ; j < high ; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i + 1;
    }
}


/*
 
*/