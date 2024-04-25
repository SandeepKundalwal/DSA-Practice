import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int edges[][] = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length + 1);

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.union(u, v)){
                return edge;
            }
        }
        return new int[2];
    }

    static class DSU{
        int parents[];
        int ranks[];

        public DSU(int n){
            parents = new int[n];
            ranks = new int[n];

            for(int i = 0; i < n; i++){
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public int findParent(int node){
            if(parents[node] == node){
                return node;
            }

            return parents[node] = findParent(parents[node]);
        }

        public boolean union(int u, int v){
            int p_u = findParent(u);
            int p_v = findParent(v);

            if(p_u == p_v) return true;

            if(ranks[p_u] < ranks[p_v]){
                parents[p_u] = parents[p_v];
                ranks[p_v] += ranks[p_u];
            } else {
                parents[p_v] = parents[p_u];
                ranks[p_u] += ranks[p_v];
            }
            return false;
        }
    }
}