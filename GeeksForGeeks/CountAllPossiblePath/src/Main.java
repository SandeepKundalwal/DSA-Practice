public class Main {
    /*
      You are presented with an undirected connected graph consisting of n vertices
       and connections between them represented by an adjacency matrix. Your objective
        is to determine whether it is possible to start traversing from a node, x, and
        return to it after traversing all the vertices at least once, using each edge exactly once.
     */
    public static void main(String[] args) {
        int paths[][] = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println(isPossible(paths) == 1 ? "true" : "false");
    }

    public static int isPossible(int[][] paths)
    {
        for(int i = 0; i < paths.length; i++){
            int countConnections = 0;
            for(int j = 0; j < paths.length; j++){
                if(paths[i][j] == 1) countConnections++;
            }
            if(countConnections % 2 == 1) return 0;
        }
        return 1;
    }
}