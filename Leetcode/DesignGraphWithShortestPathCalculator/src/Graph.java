import java.util.Arrays;

class Graph {
    // Floyd-Warhsall Algorithm
    int n;
    final int graph[][];
    int INT_MAX = 1000000000;
    public Graph(int n, int[][] edges) {
        this.n = n;
        graph = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(graph[i], INT_MAX);
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u][v] = w;
        }

        for(int i = 0; i < n; i++){
            graph[i][i] = 0;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = Math.min(graph[i][j], graph[i][u] + graph[v][j] + w);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return graph[node1][node2] == INT_MAX ? -1 : graph[node1][node2];
    }
}