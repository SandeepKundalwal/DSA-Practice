public class DisjointSet {
    int parent[];
    int size[];

    public DisjointSet(int n){
        this.parent = new int[n];
        this.size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    public void union(int i, int j){
        int representativeI = find(i);
        int representativeJ = find(j);

        if(representativeI == representativeJ){
            return;
        }

        if(size[representativeI] < size[representativeJ]){
            parent[representativeI] = representativeJ;
            size[representativeJ] += size[representativeI];
        } else {
            parent[representativeJ] = representativeI;
            size[representativeI] += size[representativeJ];
        }
    }
}
