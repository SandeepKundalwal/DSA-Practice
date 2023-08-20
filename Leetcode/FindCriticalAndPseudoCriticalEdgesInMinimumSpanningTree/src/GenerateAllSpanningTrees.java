import java.util.*;

public class GenerateAllSpanningTrees {
    // Minimum Spanning Tree, so Prim's or Kruskal's Algorithm.
    /**
     1. Find all the MSTs possible
     2. Find the common edges
     3. Other edges of all the MSTs
     */
    static List<List<Edge>> allMST = new ArrayList<>();
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // Edge Case: Check if all the weights are equal. If yes, all the edges will be pseudo-critical edge
        Edge edge[] = new Edge[edges.length];
        for(int i = 0; i < edges.length; i++){
            edge[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        }

        Arrays.sort(edge, (a, b) -> (a.weight - b.weight));

        int MSTWeight = 0;
        int edgesAdded = 0;
        DisjointSet DJ = new DisjointSet(n);
        for(int i = 0; i < edges.length && edgesAdded != n - 1; i++){
            int u = edge[i].src;
            int v = edge[i].dest;
            int w = edge[i].weight;

            if(DJ.find(u) != DJ.find(v)){
                MSTWeight += w;
                DJ.union(u, v);
                edgesAdded++;
            }
        }

        isPossibleMST(0, MSTWeight, n, edge, new ArrayList<>());

        HashMap<Integer, Integer> edgeFreq = new HashMap<>();
        for(List<Edge> MST : allMST){
            for(Edge e : MST){
                if(!edgeFreq.containsKey(e.edgeNo)){
                    edgeFreq.put(e.edgeNo, 1);
                } else {
                    edgeFreq.put(e.edgeNo, edgeFreq.get(e.edgeNo) + 1);
                }

            }
        }

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> psuedoCriticalEdges = new ArrayList<>();
        for(Map.Entry<Integer, Integer> it : edgeFreq.entrySet()){
            if(it.getValue() == allMST.size()){
                criticalEdges.add(it.getKey());
            } else {
                psuedoCriticalEdges.add(it.getKey());
            }
        }

        List<List<Integer>> finalAns = new ArrayList<>();
        finalAns.add(criticalEdges);
        finalAns.add(psuedoCriticalEdges);
        return finalAns;
    }

    public static void isPossibleMST(int idx, int MSTWeight, int n, Edge edge[], List<Edge> graph){
        if(graph.size() == n - 1){
            //check for cycle, connected and MST
            if(checkIfValidMST(MSTWeight, n, graph)){
                //storeItInSomeDataStructure
                allMST.add(new ArrayList<Edge>(graph));
            }
            return;
        }

        if(idx >= edge.length){
            return;
        }

        // don't take the current edge
        isPossibleMST(idx + 1, MSTWeight, n, edge, graph);

        graph.add(new Edge(edge[idx].src, edge[idx].dest, edge[idx].weight, edge[idx].edgeNo));
        isPossibleMST(idx + 1, MSTWeight, n, edge, graph);
        graph.remove(graph.size() - 1);
    }

    public static  boolean checkIfValidMST(int MSTWeight, int n, List<Edge> graph){
        int noOfEdgesSelected = 0;
        DisjointSet DJ = new DisjointSet(n);
        int currentMSTWeight = 0;
        for(Edge edge : graph){
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if(DJ.find(u) != DJ.find(v)){
                currentMSTWeight += w;
                DJ.union(u, v);
                noOfEdgesSelected++;
            }
        }

        if(noOfEdgesSelected != n - 1){
            return false;
        }

        return currentMSTWeight == MSTWeight;
    }
}
