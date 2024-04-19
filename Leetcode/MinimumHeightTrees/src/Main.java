import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int edges[][] = {
                {1,0}, {1,2}, {1,3}
        };
        System.out.println(findMinHeightTrees(n, edges));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return new ArrayList<>(List.of(0));
        }

        List<Integer> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        int indegree[] = new int[n];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);

            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }

        List<Integer> MHTs = new ArrayList<>();
        while(!queue.isEmpty()){
            MHTs.clear();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.remove();
                MHTs.add(node);
                for(int neighbour : graph[node]){
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 1){
                        queue.offer(neighbour);
                    }
                }
            }

        }

        return MHTs;
    }
}