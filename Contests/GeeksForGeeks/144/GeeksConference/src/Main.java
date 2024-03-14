import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int N = 4;
        int arr[][] = {{1,2},{3,4},{1,3},{2,4}};
        System.out.println(maximumFriends(N, arr));
    }

    public static ArrayList<Integer> maximumFriends(int N, int[][] arr) {
        int max = 0;
        for(int a[] : arr){
            max = Math.max(max, Math.max(a[0], a[1]));
        }

        DSU dsu = new DSU(max + 1);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int a[] : arr){
            int u = a[0];
            int v = a[1];

            dsu.union(u, v);
            ans.add(dsu.maxi);
        }

        return ans;
    }

    static class DSU{
        int maxi;
        int parents[];
        int size[];

        public DSU(int n){
            this.maxi = Integer.MIN_VALUE;
            this.parents = new int[n];
            this.size = new int[n];

            for(int i = 0; i < n; i++){
                this.parents[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int e){
            if(this.parents[e] == e){
                return e;
            }
            return this.parents[e] = find(this.parents[e]);
        }

        public void union(int u, int v){
            int p_u = find(u);
            int p_v = find(v);

            if(p_u == p_v) return;

            if(this.size[p_u] <= this.size[p_v]){
                this.parents[p_u] = p_v;
                this.size[p_v] += this.size[p_u];
                this.maxi = Math.max(maxi, this.size[p_v] - 1);
            } else {
                this.parents[p_v] = p_u;
                this.size[p_u] += this.size[p_v];
                this.maxi = Math.max(maxi, this.size[p_u] - 1);
            }
        }
    }
}