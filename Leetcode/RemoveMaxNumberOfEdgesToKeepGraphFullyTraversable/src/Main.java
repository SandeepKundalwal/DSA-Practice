public class Main {
    public static void main(String[] args) {
        int n = 4;
        int edges[][] = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(maxNumEdgesToRemove(n, edges));
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU bob = new DSU(n);
        DSU alice = new DSU(n);

        int removeEdge = 0;
        for(int[] edge : edges){
            int t = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(t == 3){
                if(bob.find(u) == bob.find(v)){
                    removeEdge++;
                } else {
                    bob.union(u, v);
                    alice.union(u, v);
                }
            }
        }

        for(int[] edge : edges){
            int t = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(t == 1){
                if(!alice.union(u, v)) {
                    removeEdge++;
                }
            }
        }

        for(int[] edge : edges){
            int t = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(t == 2){
                if(!bob.union(u, v)) {
                    removeEdge++;
                }
            }
        }

        if(!alice.isSingleComponent() || !bob.isSingleComponent()){
            return -1;
        }

        return removeEdge;
    }

    static class DSU {
        private int[] rank;
        private int[] parent;
        private int componentCount;

        public DSU(int n){
            this.componentCount = n;
            this.rank = new int[n + 1];
            this.parent = new int[n + 1];

            for(int i = 1; i <= n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int node){
            if(this.parent[node] == node){
                return node;
            }

            return this.parent[node] = find(this.parent[node]);
        }

        public boolean union(int u, int v){
            int u_parent = find(u);
            int v_parent = find(v);

            if(u_parent == v_parent) return false;

            if(this.rank[u_parent] > this.rank[v_parent]){
                this.parent[v_parent] = u_parent;
                this.rank[u_parent] += this.rank[v_parent];
            } else {
                this.parent[u_parent] = v_parent;
                this.rank[v_parent] += this.rank[u_parent];
            }

            this.componentCount--;

            return true;
        }

        public boolean isSingleComponent(){
            return this.componentCount == 1;
        }
    }
}