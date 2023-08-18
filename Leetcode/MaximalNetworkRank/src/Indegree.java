import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Indegree {
    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        int indegree[] = new int[n];
        for(int road[] : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
            indegree[road[0]]++;
            indegree[road[1]]++;
        }


        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // all the cities do not have to be connected
                // check if the cities are connected: 1. if connected then reduce 1;
                //                                    2. otherwise don't reduce
                boolean isConnected = isNetworkConnected(i, j, graph);

                maxi = Math.max(maxi, (isConnected ? indegree[i] + indegree[j] - 1 : indegree[i] + indegree[j]));
            }
        }
        return maxi;
    }

    public static boolean isNetworkConnected(int i, int j, Map<Integer, List<Integer>> graph){
        for(int node : graph.get(i)){
            if(node == j){
                return true;
            }
        }

        return false;
    }
}
