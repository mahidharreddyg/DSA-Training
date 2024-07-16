import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxFlow {

    // Number of vertices in the graph
    static final int V = 6; 

    // Returns true if there is a path from source 's' to sink 't' in residual graph.
    // Also fills parent[] to store the path
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        // Create a visited array and mark all vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;

        // Create a queue, enqueue source vertex and mark source vertex as visited
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) { // Check if the vertex is not visited and there is a connection
                    // If we find a connection to the sink node, then there is no point in BFS anymore. We just return true
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        // We didn't reach sink in BFS starting from source, so return false
        return false;
    }

    // Returns the maximum flow from s to t in the given graph
    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;

        // Create a residual graph and fill the residual graph with given capacities in the original graph as residual capacities in residual graph
        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        // This array is filled by BFS and to store path
        int parent[] = new int[V];

        int maxFlow = 0;  // There is no flow initially

        // Augment the flow while there is a path from source to sink
        while (bfs(rGraph, s, t, parent)) {
            // Find the maximum flow through the path found by BFS
            int pathFlow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            // update residual capacities of the edges and reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            // Add path flow to overall flow
            maxFlow += pathFlow;
        }

        // Return the overall flow
        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input for the graph
        int graph[][] = new int[V][V];
        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        MaxFlow m = new MaxFlow();

        // Source is 0 and Sink is V-1 (5 in this case)
        int source = 0;
        int sink = V - 1;

        System.out.println("The maximum flow is " + m.fordFulkerson(graph, source, sink));
    }
}
