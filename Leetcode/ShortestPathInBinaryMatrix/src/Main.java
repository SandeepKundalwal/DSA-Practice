import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int directions[][] = {
            {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
    };
    public static void main(String[] args) {
        int grid[][] = {{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;

        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;

        int length = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int location[] = queue.remove();
                int i = location[0];
                int j = location[1];

                if(i == n - 1 && j == n - 1){
                    return length + 1;
                }

                for(int direction[] : directions){
                    int dI = i + direction[0];
                    int dJ = j + direction[1];

                    if(insideMatrix(dI, dJ, n) && !visited[dI][dJ] && grid[dI][dJ] == 0){
                        visited[dI][dJ] = true;
                        queue.offer(new int[]{dI, dJ});
                    }
                }
            }
            length++;
        }
        return -1;
    }

    public static boolean insideMatrix(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}