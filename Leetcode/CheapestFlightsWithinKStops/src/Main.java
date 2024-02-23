import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 2;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer[]>> graph = generateGraph(n, flights);

        int costs[] = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(src, 0));

        while(!queue.isEmpty() && k >= 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.remove();
                for(Integer[] neighbor : graph.get(node.id)){
                    int des = neighbor[0];
                    int cost = neighbor[1];

                    if(node.cost + cost < costs[des]){
                        costs[des] =  node.cost + cost;
                        queue.offer(new Node(des, costs[des]));
                    }
                }
            }
            k--;
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public static Map<Integer,  List<Integer[]>> generateGraph(int n, int flights[][]){
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int flight[] : flights){
            int src = flight[0];
            int des = flight[1];
            int cost = flight[2];

            graph.get(src).add(new Integer[]{des, cost});
        }

        return graph;
    }

    static class Node{
        int id;
        int cost;

        public Node(int id, int cost){
            this.id = id;
            this.cost = cost;
        }
    }
}