import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int points[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }

    /**
     Find MST
     */
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.mDist - b.mDist);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    priorityQueue.offer(new Edge(i, j, calculateManhattanDistance(points[i][0], points[j][0], points[i][1], points[j][1])));
                }
            }
        }

        DSU dsu = new DSU(n);

        int i = 0;
        int minCost = 0;
        while(i < n - 1){
            Edge node = priorityQueue.remove();
            int src = node.src;
            int dest = node.dest;
            int mDist = node.mDist;

            if(dsu.findParent(src) != dsu.findParent(dest)){
                i++;
                minCost += mDist;
                dsu.union(src, dest);
            }
        }
        return minCost;
    }

    public static int calculateManhattanDistance(int x1, int x2, int y1, int y2){
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }

    static class Edge{
        int src;
        int dest;
        int mDist;

        public Edge(int src, int dest, int mDist){
            this.src = src;
            this.dest = dest;
            this.mDist = mDist;
        }
    }

    static class DSU{
        int size[];
        int parent[];

        public DSU(int n){
            size = new int[n];
            parent = new int[n];
            for(int i = 0; i < n; i++){
                size[i] = 0;
                parent[i] = i;
            }
        }

        public int findParent(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public void union(int u, int v){
            int parentU = findParent(u);
            int parentV = findParent(v);

            if(parentU == parentV) return;
            if(size[parentU] < size[parentV]){
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            } else {
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }
        }
    }
}