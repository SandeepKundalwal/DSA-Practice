import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int edges[][] = {{2,0,1},{0,1,1},{0,3,4},{3,2,2}};
        System.out.println(Arrays.toString(findAnswer(n, edges)));
    }

    public static boolean[] findAnswer(int n, int[][] edges) {
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

        int srcDis[] = dijkstras(0, n, graph);
        int desDis[] = dijkstras(n - 1, n, graph);

        long shortestDistance = srcDis[n - 1];
        boolean answer[] = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if((srcDis[u] + (long)w + desDis[v] == shortestDistance) || (srcDis[v] + (long)w + desDis[u] == shortestDistance)){
                answer[i] = true;
            }
        }

        return answer;
    }

    public static int[] dijkstras(int src, int n, List<Pair> graph[]){
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.w - b.w));
        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()){
            int u = pq.remove().v;
            for(Pair neighborPair : graph[u]){
                if(distance[neighborPair.v] > neighborPair.w + distance[u]){
                    distance[neighborPair.v] = neighborPair.w + distance[u];
                    pq.offer(new Pair(neighborPair.v, distance[neighborPair.v]));
                }
            }
        }

        return distance;
    }

    static class Pair{
        int v;
        int w;

        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}