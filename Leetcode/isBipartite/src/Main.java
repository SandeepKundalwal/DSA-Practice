import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Is the given graph bipartite: " + isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        // to handle disconnected graph
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!isGraphBipartite(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * using BFS
     * @param graph given graph
     * @param src source vertex
     * @param color color array that represents the color of each vertex
     * @return whether the given connected component is bipartite or not
     */
    public static boolean isGraphBipartite(int[][] graph, int src, int[] color){
        color[src] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int u = queue.remove();
            for(int v : graph[u]){
                // System.out.println("u:" + u + " v: " + v + " color[u]: " + color[u] + " color[v]: " + color[v]);
                if(color[v] == -1){
                    queue.add(v);
                    color[v] = 1 - color[u];
                } else if (color[v] == color[u]){
                    return false;
                }
            }
        }
        return true;
    }
}