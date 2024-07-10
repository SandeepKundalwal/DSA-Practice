import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int directions[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) {
        int grid[][] = {{2, 1, 1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> rottenOranges = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                } else if(grid[i][j] == 2){
                    rottenOranges.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;
        while(!rottenOranges.isEmpty() && freshOranges > 0){
            int size = rottenOranges.size();
            for(int i = 0; i < size; i++){
                int position[] = rottenOranges.remove();

                for(int direction[] : directions){
                    int dI = position[0] + direction[0];
                    int dJ = position[1] + direction[1];

                    if(isValidCell(dI, dJ, m, n) && grid[dI][dJ] == 1){
                        freshOranges--;
                        grid[dI][dJ] = 2;
                        rottenOranges.offer(new int[]{dI, dJ});
                    }
                }
            }
            time++;
        }

        return freshOranges == 0 ? time : -1;
    }

    public static boolean isValidCell(int i, int j, int m, int n){
        return 0 <= i && 0 <= j && i < m && j < n;
    }
}