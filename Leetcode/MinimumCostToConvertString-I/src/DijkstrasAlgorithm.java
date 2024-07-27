import java.util.*;

public class DijkstrasAlgorithm {

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int m = source.length();
        int n = original.length;

        Map<Character, List<Pair>> graph = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++){
            graph.put(c, new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            char u = original[i];
            char v = changed[i];
            int c = cost[i];

            graph.get(u).add(new Pair(v, c));
        }

        long d[][] = new long[26][26];
        for(char c = 'a'; c <= 'z'; c++){
            d[c - 'a'] = dijkstrasAlgorithm(c, graph);
        }

        long mini = 0;
        for(int i = 0; i < m; i++){
            int src = source.charAt(i) - 'a';
            int des = target.charAt(i) - 'a';

            // if(src == des) continue;

            long c = d[src][des];

            if(c >= Integer.MAX_VALUE){
                return -1;
            } else {
                mini += c;
            }
        }

        return mini;
    }

    public static long[] dijkstrasAlgorithm(char src, Map<Character, List<Pair>> graph){
        long d[] = new long[26];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new Pair(src, 0));
        d[src - 'a'] = 0;

        while(!pq.isEmpty()){
            char u = pq.remove().node;

            for(Pair v : graph.get(u)){
                if(d[v.node - 'a'] > d[u - 'a'] + v.cost){
                    d[v.node - 'a'] = d[u - 'a'] + v.cost;
                    pq.offer(new Pair(v.node, d[v.node - 'a']));
                }
            }
        }

        return d;
    }

    static class Pair{
        char node;
        long cost;

        public Pair(char node, long cost){
            this.node = node;
            this.cost = cost;
        }
    }
}
