import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int queries[][] = {{2,4},{0,2},{0,4}};
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(n, queries)));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Integer> edges = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            edges.put(i, i + 1);
        }

        int m = queries.length;
        int answer[] = new int[m];
        for(int i = 0; i < m; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            if(edges.containsKey(u) && edges.get(u) < v){
                int it = u;
                while(it < v && edges.containsKey(it)){
                    it = edges.remove(it);
                }
                edges.put(u, v);
            }

            answer[i] = edges.size();
        }

        return answer;
    }
}