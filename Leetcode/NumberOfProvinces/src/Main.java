import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println("Number of Provinces: " + findCircleNum(isConnected));
    }

    /**
     * graph is undirected
     * Basically find the number of disconnected components of a graph
    */
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected[0].length];
        Arrays.fill(visited, false);

        int noOfProvinces = 0;
        for(int i = 0; i < isConnected[0].length; i++){
            if(!visited[i]){
                traverseTheProvince(isConnected, i, visited);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
    }

    public static void traverseTheProvince(int[][] isConnected, int src, boolean[] visited){
        visited[src] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int u = queue.remove();
            for(int v = 0; v < isConnected[u].length; v++){
                if(isConnected[u][v] == 1 && !visited[v]){
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}