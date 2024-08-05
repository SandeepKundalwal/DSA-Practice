import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int queries[][] = {{2,4},{0,2},{0,4}};
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(n, queries)));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            graph.get(i).add(i + 1);
        }

        int answer[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(v);

            answer[i] = runBFS(n, graph);
        }

        return answer;
    }

    public static int runBFS(int n, Map<Integer, List<Integer>> graph){
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int u = queue.remove();
                visited[u] = true;

                for(int v : graph.get(u)){
                    if(v == n - 1) return distance;

                    if(!visited[v]){
                        queue.offer(v);
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}