import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int edges[][] = {
                {0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}
        };
        System.out.println(findCriticalAndPseudoCriticalEdges(n, edges));
    }

    // Minimum Spanning Tree, so Prim's or Kruskal's Algorithm.
    /**
     1. Find all the MSTs possible
     2. Find the common edges
     3. Other edges of all the MSTs
     */
    static List<List<Edge>> allMST = new ArrayList<>();
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Edge edge[] = new Edge[edges.length];
        for(int i = 0; i < edges.length; i++){
            edge[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        }
        DisjointSet DJ = new DisjointSet(n);

        Arrays.sort(edge, (a, b) -> (a.weight - b.weight));

        int MSTWeight = 0;
        int edgesAdded = 0;
        for(int i = 0; i < edges.length && edgesAdded != n - 1; i++){
            int u = edge[i].src;
            int v = edge[i].dest;
            int w = edge[i].weight;

            if(DJ.find(u) != DJ.find(v)){
                MSTWeight += w;
                DJ.union(u, v);
                edgesAdded++;
                // System.out.print(u + "->" + v + " ");
            }
        }

        //Generate All Spanning Trees O(ElogV + V + noOfSpanningTreesPossible == V^3)
        isPossibleMST(0, MSTWeight, n, edge, new ArrayList<>());

//        for(List<Edge> MST : allMST){
//            for(Edge e : MST){
//                System.out.println(e.src + "->" + e.dest + "->" + e.edgeNo);
//            }
//            System.out.println();
//        }



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
                allMST.add(new ArrayList<>(graph));
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

    public static boolean checkIfValidMST(int MSTWeight, int n, List<Edge> graph){
        DisjointSet DJ = new DisjointSet(n);
        int currentMSTWeight = 0;
        for(Edge edge : graph){
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if(DJ.find(u) != DJ.find(v)){
                currentMSTWeight += w;
                DJ.union(u, v);
            }
        }

        for(int i = 1; i < n; i++){
            if(DJ.parent[i - 1] != DJ.parent[i]){
                return false;
            }
        }

        return currentMSTWeight == MSTWeight;
    }

    public static class Edge{
        int src;
        int dest;
        int weight;
        int edgeNo;

        public Edge(int src, int dest, int weight, int edgeNo){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
            this.edgeNo = edgeNo;
        }
    }

    // Union By Size
    public static class DisjointSet{
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
}