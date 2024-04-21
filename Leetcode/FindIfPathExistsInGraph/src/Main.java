public class Main {
    public static void main(String[] args) {
        int n = 3;
        int edges[][] = {{0,1},{1,2},{2,0}};
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);

        for(int edge[] : edges){
            dsu.union(edge[0], edge[1]);
        }

        return dsu.findParent(source) == dsu.findParent(destination);
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

        public void union(int u, int v){
            int p_u = findParent(u);
            int p_v = findParent(v);

            if(p_u == p_v) return;

            if(ranks[p_u] <= ranks[p_v]){
                parents[p_u] = parents[p_v];
                ranks[p_v] += ranks[p_u];
            } else {
                parents[p_v] = parents[p_u];
                ranks[p_u] += ranks[p_v];
            }
        }
    }
}