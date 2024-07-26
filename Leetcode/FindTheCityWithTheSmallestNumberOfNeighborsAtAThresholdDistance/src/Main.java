import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int edges[][] = {{0,1,3},{0,2,6},{0,3,2},{1,2,2},{1,3,5},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Pair> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        int ansNode = -1;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int d[] = dijkstraAlgorithm(i, graph);

            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i != j && d[j] <= distanceThreshold){
                    cnt++;
                }
            }

            if(cnt <= mini){
                mini = cnt;
                ansNode = i;
            }
        }

        return ansNode;
    }

    public static int[] dijkstraAlgorithm(int src, List<Pair> graph[]){
        int d[] = new int[graph.length];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.offer(new Pair(src, 0));
        d[src] = 0;

        while(!pq.isEmpty()){
            Pair u = pq.remove();

            for(Pair v : graph[u.node]){
                if(d[v.node] > d[u.node] + v.weight){
                    d[v.node] = d[u.node] + v.weight;
                    pq.offer(new Pair(v.node, d[v.node]));
                }
            }
        }

        return d;
    }

    static class Pair{
        int node;
        int weight;

        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
}