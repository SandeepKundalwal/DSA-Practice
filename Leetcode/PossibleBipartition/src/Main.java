import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int dislikes[][] = {{1,4},{2,3},{5,6},{4,6}};
        System.out.println(possibleBipartition(n, dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer> graph[] = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int dislike[] : dislikes){
            int u = dislike[0];
            int v = dislike[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int colors[] = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            if(colors[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0; j < size; j++){
                    int u = queue.remove();
                    int colorIt = colors[u] == 1 ? 2 : 1;

                    for(int v : graph[u]){
                        if(colors[v] == colors[u]){
                            return false;
                        }

                        if(colors[v] == 0){
                            queue.offer(v);
                            colors[v] = colorIt;
                        }
                    }
                }
            }
        }
        return true;
    }
}