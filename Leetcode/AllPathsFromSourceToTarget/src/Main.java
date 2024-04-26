import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int graph[][] = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> possiblePaths = new ArrayList<>();

        boolean visited[] = new boolean[n];

        dfs(0, new boolean[n], new ArrayList<>(), possiblePaths, graph);

        return possiblePaths;
    }

    public static void dfs(int node, boolean visited[], List<Integer> currentPath, List<List<Integer>> possiblePaths, int graph[][]){
        if(node == graph.length - 1){
            List<Integer> latestPath = new ArrayList<>();
            latestPath.add(0);
            latestPath.addAll(currentPath);
            possiblePaths.add(latestPath);
            return;
        }

        visited[node] = true;
        for(int neighbor : graph[node]){
            if(!visited[neighbor]){
                currentPath.add(neighbor);
                dfs(neighbor, visited, currentPath, possiblePaths, graph);
                currentPath.remove(currentPath.size() - 1);
            }
        }
        visited[node] = false;
    }
}