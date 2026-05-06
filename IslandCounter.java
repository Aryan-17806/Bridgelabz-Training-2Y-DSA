import java.util.Scanner;

public class IslandCounter {

    static int rows, cols;
    public static int numIslands(int[][] arr) {
        if (arr == null || arr.length == 0) return 0;

        rows = arr.length;
        cols = arr  [0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    dfs(arr, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || arr[i][j] == 0) {
            return;
        }

        arr[i][j] = 0;

        dfs(arr, i + 1, j);
        dfs(arr, i - 1, j);
        dfs(arr, i, j + 1);
        dfs(arr, i, j - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int [][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        input.close();

        System.out.println("Number of Islands: " + numIslands(arr));
    }
}