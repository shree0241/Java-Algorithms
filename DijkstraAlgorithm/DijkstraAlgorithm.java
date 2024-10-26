import java.util.*;

public class DijkstraAlgorithm {
    static class Node {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = { 
            { 0, 10, 0, 30, 100 },
            { 10, 0, 50, 0, 0 },
            { 0, 50, 0, 20, 10 },
            { 30, 0, 20, 0, 60 },
            { 100, 0, 10, 60, 0 }
        };
        DijkstraAlgorithm da = new DijkstraAlgorithm();
        da.dijkstra(graph, 0);
    }
}
