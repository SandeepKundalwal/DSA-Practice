import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int T = in.nextInt();

            // take care of undirected graph
            Map<Integer, List<GraphNode>> graph = new HashMap<>();
            for(int i = 0; i < n - 1; i++){
                int src = in.nextInt();
                int dest = in.nextInt();
                int hardness = in.nextInt();

                if(!graph.containsKey(src)){
                    graph.put(src, new ArrayList<>());
                }


                if(!graph.containsKey(dest)){
                    graph.put(dest, new ArrayList<>());
                }
                graph.get(src).add(new GraphNode(dest, hardness));
                graph.get(dest).add(new GraphNode(src, hardness));
            }

            char s[] = in.next().toCharArray();

            int q = in.nextInt();
            while(q-- > 0){
                int src = in.nextInt();
                int dest = in.nextInt();

                System.out.println(minimumTime(src, dest, 1, T, s, graph));
            }
        }
    }

    // either train it and stay on the same src; or train and move to dest; or dont train and perform dfs.
    public static long minimumTime(int src, int dest, int c, int T, char s[], Map<Integer, List<GraphNode>> graph){
        boolean visited[] = new boolean[graph.size() + 1];
        List<GraphNode> path = new ArrayList<>();
        path.add(new GraphNode(src, 0));
        findPathToDestination(src, dest, visited, path, graph);
        Map<String, Long> MEMO = new HashMap<>();
        return findMinimumTimeForPath(0, c, T, s, path, MEMO);
    }

    public static long findMinimumTimeForPath(int index, int c, int T, char s[], List<GraphNode> pathToDestination, Map<String, Long> MEMO){
        if(index == pathToDestination.size() - 1){
            return 0;
        }

        String key = index + "|" + c;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }


        // I can train as long as the hardness is greater than c. OR I can train and move to the next index.
        long train = Integer.MAX_VALUE;
        if(s[pathToDestination.get(index).dest - 1] == '1' && index + 1 < pathToDestination.size() && pathToDestination.get(index + 1).hardness >= (c * 2)){
            int newC = c * 2;
            train = Math.min(T + findMinimumTimeForPath(index, newC, T, s, pathToDestination, MEMO),
                                            T + ((long) (Math.ceil((double) pathToDestination.get(index + 1).hardness / newC) + findMinimumTimeForPath(index + 1, newC, T, s, pathToDestination, MEMO))));
        }

        long dontTrain = Integer.MAX_VALUE;
        if(index + 1 < pathToDestination.size()){
            dontTrain = (long) (Math.ceil((double) pathToDestination.get(index + 1).hardness / c) + findMinimumTimeForPath(index + 1, c, T, s, pathToDestination, MEMO));

        }

        MEMO.put(key, Math.min(train, dontTrain));
        return MEMO.get(key);
    }

    public static boolean findPathToDestination(int src, int dest, boolean visited[], List<GraphNode> path, Map<Integer, List<GraphNode>> graph){
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(GraphNode neighbour : graph.get(src)){
            if(!visited[neighbour.dest]){
                path.add(neighbour);
                if(findPathToDestination(neighbour.dest, dest, visited, path, graph)){
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static class GraphNode {
        int dest;
        int hardness;

        public GraphNode(int dest, int hardness){
            this.dest = dest;
            this.hardness = hardness;
        }
    }
}