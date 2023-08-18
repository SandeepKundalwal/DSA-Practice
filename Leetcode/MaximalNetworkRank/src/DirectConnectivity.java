import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectConnectivity {
    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int road[] : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // all the cities do not have to be connected
                // check if the cities are connected: 1. if connected then reduce 1;
                //                                    2. otherwise dont reduce
                maxi = Math.max(maxi, findNetworkRank(i, j, graph));
            }
        }
        return maxi;
    }

    public static int findNetworkRank(int i, int j, Map<Integer, List<Integer>> graph){
        int cnt = 0;
        boolean isConnected = false;
        for(int node : graph.get(i)){
            if(node == j){
                isConnected = true;
            }
            cnt++;
        }

        for(int node : graph.get(j)){
            cnt++;
        }

        return isConnected == true ? cnt - 1 : cnt;
    }
}
