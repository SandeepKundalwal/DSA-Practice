import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Is the given graph bipartite: " + isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];

        for(int i = 0; i < n; i++){
            if(colors[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0; j < size; j++){
                    int node = queue.remove();
                    int color = colors[node];
                    int colorIt = color == 1 ? 2 : 1;

                    for(int neighbor : graph[node]){
                        if(color == colors[neighbor]){
                            return false;
                        }

                        if(colors[neighbor] == 0){
                            colors[neighbor] = colorIt;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        return true;
    }
}