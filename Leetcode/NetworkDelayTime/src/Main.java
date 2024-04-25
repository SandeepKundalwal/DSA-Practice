import java.util.*;

public class Main {
    public static void main(String[] args) {
        int times[][] = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        for(int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int time[] : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new Integer[]{v, w});
        }

        int d[] = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;

        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new Integer[]{k, 0});

        while(!minHeap.isEmpty()){
            Integer pair[] = minHeap.remove();

            int u = pair[0];
            int w = pair[1];

            for(Integer neighbour[] : graph.get(u)){
                if(w + neighbour[1] < d[neighbour[0]]){
                    d[neighbour[0]] = w + neighbour[1];
                    minHeap.offer(new Integer[]{neighbour[0], d[neighbour[0]]});
                }
            }
        }

        int time = 0;
        for(int i = 1; i <= n; i++){
            if(d[i] == Integer.MAX_VALUE){
                return -1;
            }
            time = Math.max(time, d[i]);
        }

        return time;
    }
}