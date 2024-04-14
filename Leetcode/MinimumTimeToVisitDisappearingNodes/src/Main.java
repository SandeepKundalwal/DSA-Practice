import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int edges[][] = {{0,1,2},{1,2,1},{0,2,4}};
        int disappear[] = {1, 1, 5};
        System.out.println(Arrays.toString(minimumTime(n, edges, disappear)));
    }

    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int edge[] : edges){
            int src = edge[0];
            int des = edge[1];
            int cost = edge[2];

            graph.get(src).add(new Pair(des, cost));
            graph.get(des).add(new Pair(src, cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        pq.offer(new Pair(0, 0));

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean visited[] = new boolean[n];
        while(!pq.isEmpty()){
            int src = pq.remove().des;

            if(visited[src] == true) continue;

            visited[src] = true;

            for(Pair pair : graph.get(src)){
                int des = pair.des;
                int cost = pair.cost;

                if(dist[src] + cost < dist[des] && dist[src] + cost < disappear[des]){
                    dist[des] = dist[src] + cost;
                    pq.offer(new Pair(des, dist[des]));
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }

        return dist;
    }

    static class Pair{
        int des;
        int cost;

        public Pair(int des, int cost){
            this.des = des;
            this.cost = cost;
        }
    }
}