import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalApproach {
    // Minimum Spanning Tree, so Prim's or Kruskal's Algorithm.
    /**
     1. Find all the MSTs possible
     2. Find the common edges
     3. Other edges of all the MSTs
     */
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // Edge Case: Check if all the weights are equal. If yes, all the edges will be pseudo-critical edge
        Edge newEdges[] = new Edge[edges.length];
        for(int i = 0; i < edges.length; i++){
            newEdges[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        }

        Arrays.sort(newEdges, (a, b) -> (a.weight - b.weight));

        int MSTWeight = runKruskal(n, newEdges, -1, -1);

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        for(int i = 0; i < newEdges.length; i++){
            // if I exclude the current edge and the MST that I am getting has weight greater than original MST, then the edge is critical
            if(MSTWeight < runKruskal(n, newEdges, -1, i)){
                criticalEdges.add(newEdges[i].edgeNo);
            } else if(MSTWeight == runKruskal(n, newEdges, i, -1)){
                pseudoCriticalEdges.add(newEdges[i].edgeNo);
            }
        }

        return new ArrayList<>(
                Arrays.asList(criticalEdges, pseudoCriticalEdges)
        );
    }

    public static int runKruskal(int n, Edge[] newEdges, int includeEdge, int excludeEdge){
        DisjointSet DSU = new DisjointSet(n);

        int MSTWeight = 0;
        if(includeEdge != -1){
            MSTWeight += newEdges[includeEdge].weight;
            DSU.union(newEdges[includeEdge].src, newEdges[includeEdge].dest);
        }

        for(int i = 0; i < newEdges.length; i++){
            if(i == excludeEdge){
                continue;
            }

            int src = newEdges[i].src;
            int dest = newEdges[i].dest;
            int weight = newEdges[i].weight;
            if(DSU.find(src) != DSU.find(dest)){
                MSTWeight += weight;
                DSU.union(src, dest);
            }
        }

        // Checking for connected component
        for (int i = 0; i < n; i++) {
            if (DSU.find(i) != DSU.find(0))
                return Integer.MAX_VALUE;
        }
        return MSTWeight;
    }
}
