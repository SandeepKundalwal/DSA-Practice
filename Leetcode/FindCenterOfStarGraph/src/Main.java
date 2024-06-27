public class Main {
    public static void main(String[] args) {
        int edges[][] = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        int n = edges.length;
        int indegree[] = new int[n + 2];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            indegree[u]++;
            indegree[v]++;
        }

        for(int i = 1; i < n + 2; i++){
            if(indegree[i] == n) return i;
        }

        return -1;
    }
}