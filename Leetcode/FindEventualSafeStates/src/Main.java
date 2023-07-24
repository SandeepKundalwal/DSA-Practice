import java.util.*;

public class Main {
    public static void main(String[] args) {
        int graph[][] = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println("Safe States are: " + Arrays.toString(eventualSafeNodes(graph).toArray()));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                adjList.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        boolean[] safe = new boolean[n];
        while(!queue.isEmpty()){
            int node = queue.poll();
            safe[node] = true;

            for(int neighbour : adjList.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(safe[i]){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}