import java.util.*;

class Edge {
    int node, weight;
    Edge(int n, int w) {
        node = n;
        weight = w;
    }
}

public class CityGraph {

    static int bfs(int n, List<List<Edge>> arr, int start, int end) {
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

                for (Edge e : arr.get(curr)) {
                    if (!visited[e.node]) {
                        visited[e.node] = true;
                        q.add(e.node);
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

        List<List<Edge>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            int type = input.nextInt(); 

            arr.get(u).add(new Edge(v, w));
            if (type == 2) {
                arr.get(v).add(new Edge(u, w));
            }
        }

        int start = input.nextInt();
        int end = input.nextInt();

        input.close();

        System.out.println("Minimum Turns: " + bfs(n, arr, start, end));
    }
}