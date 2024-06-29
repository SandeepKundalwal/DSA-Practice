import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int edges[][] = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        System.out.println(getAncestors(n, edges));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        // reversing the graph
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            graph[v].add(u);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            answer.add(new ArrayList<>());
            boolean visited[] = new boolean[n];

            findAncestors(i, graph, visited);

            // find a way to add to the answer
            visited[i] = false;
            for(int j = 0; j < n; j++){
                if(visited[j] == false) continue;
                answer.get(i).add(j);
            }
        }

        return answer;
    }

    public static void findAncestors(int src, List<Integer> graph[], boolean visited[]){
        visited[src] = true;
        for(int neighbor : graph[src]){
            if(visited[neighbor]) continue;
            findAncestors(neighbor, graph, visited);
        }
    }
}