import java.util.*;

public class SocialNetwork {

    public static int shortestPath(int n, List<List<Integer>> arr, int start, int end) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == end) return level;

                for (int nei : arr.get(curr)) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        q.add(nei);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); 
        int e = input.nextInt(); 

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = input.nextInt();
            int v = input.nextInt();

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        int start = input.nextInt();
        int end = input.nextInt();

        input.close();

        System.out.println("Degree of Separation: " + shortestPath(n, arr, start, end));
    }
}