import java.util.*;

public class NetworkGraph {

    static boolean isConnected(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i : graph.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    static int minHops(int n, List<List<Integer>> graph, int start, int end) {
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

                for (int nei : graph.get(curr)) {
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

        System.out.println("Connected: " + isConnected(n, arr));
        System.out.println("Minimum Hops: " + minHops(n, arr, start, end));
    }
}