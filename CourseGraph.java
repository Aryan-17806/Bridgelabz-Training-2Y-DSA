import java.util.*;

public class CourseGraph {

    static boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int nei : graph.get(node)) {
            if (dfs(nei, graph, visited, recStack)) return true;
        }

        recStack[node] = false;
        return false;
    }

    static boolean hasCycle(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, visited, recStack)) return true;
        }
        return false;
    }

    static void topoSort(int n, List<List<Integer>> graph) {
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int nei : graph.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int nei : graph.get(curr)) {
                if (--indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); 
        int e = input.nextInt(); 

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
        }

        input.close();

        if (hasCycle(n, graph)) {
            System.out.println("Cycle detected");
        } else {
            System.out.print("Topological Order: ");
            topoSort(n, graph);
        }
    }
}