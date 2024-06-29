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
            Set<Integer> visited = new HashSet<>();
            List<Integer> ancestors = new ArrayList<>();

            findAncestors(i, graph, ancestors, visited);

            // find a way to add to the answer
            Collections.sort(ancestors);
            for(int j = 0; j < ancestors.size(); j++){
                if(j != 0 && ancestors.get(j - 1) == ancestors.get(j)){
                    continue;
                }
                answer.get(i).add(ancestors.get(j));
            }
        }

        return answer;
    }

    public static void findAncestors(int src, List<Integer> graph[], List<Integer> ancestors, Set<Integer> visited){
        visited.add(src);
        for(int neighbor : graph[src]){
            if(visited.contains(neighbor)) continue;

            ancestors.add(neighbor);
            findAncestors(neighbor, graph, ancestors, visited);
        }
    }
}