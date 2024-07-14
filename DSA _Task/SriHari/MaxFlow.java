import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxFlow {
    private int numberOfVertices;
    private int[][] capacity;
    private int[] parent;

    public MaxFlow(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        capacity = new int[numberOfVertices][numberOfVertices];
        parent = new int[numberOfVertices];
    }

    public void addEdge(int from, int to, int cap) {
        capacity[from][to] = cap;
    }

    private boolean bfs(int source, int sink) {
        boolean[] visited = new boolean[numberOfVertices];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < numberOfVertices; v++) {
                if (!visited[v] && capacity[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                    if (v == sink) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int fordFulkerson(int source, int sink) {
        int maxFlow = 0;

        while (bfs(source, sink)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, capacity[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                capacity[u][v] -= pathFlow;
                capacity[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        
        MaxFlow maxFlow = new MaxFlow(vertices);

        System.out.println("Enter the capacity matrix (enter row by row): ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                int cap = scanner.nextInt();
                maxFlow.addEdge(i, j, cap);
            }
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        System.out.print("Enter the sink vertex: ");
        int sink = scanner.nextInt();

        int max_flow = maxFlow.fordFulkerson(source, sink);
        System.out.println("Maximum flow is " + max_flow);
    }
}
