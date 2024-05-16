import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    final static int directions[][] = {
            {-1,0},{0,1},{1,0},{0,-1}
    };
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(0,0,0,1),
                List.of(0,0,0,0),
                List.of(0,0,0,0),
                List.of(1,0,0,0)
        );
        System.out.println(maximumSafenessFactor(grid));
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1){
            return 0;
        }

        int nGrid[][] = findCellSafenessFactors(n, grid);

        int left = 0, right = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                right = Math.max(right, nGrid[i][j]);
            }
        }

        int ans = 0;
        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(validSafenessFactor(mid, n, nGrid)){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static boolean validSafenessFactor(int minSafenessFactor, int n, int nGrid[][]){
        if(nGrid[0][0] < minSafenessFactor || nGrid[n - 1][n - 1] < minSafenessFactor){
            return false;
        }

        Queue<Coordinate> gridTraversalQueue = new LinkedList<>();
        gridTraversalQueue.offer(new Coordinate(0, 0));

        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;

        while(!gridTraversalQueue.isEmpty()){
            int size = gridTraversalQueue.size();
            for(int k = 0; k < size; k++){
                Coordinate coordi = gridTraversalQueue.remove();

                int x = coordi.x;
                int y = coordi.y;

                if(x == n - 1 && y == n - 1){
                    return true;
                }

                for(int direction[] : directions){
                    int dX = x + direction[0];
                    int dY = y + direction[1];

                    if(isValidCell(dX, dY, n) && !visited[dX][dY] && nGrid[dX][dY] >= minSafenessFactor){
                        visited[dX][dY] = true;
                        gridTraversalQueue.offer(new Coordinate(dX, dY));
                    }
                }
            }
        }

        return false;
    }

    public static int[][] findCellSafenessFactors(int n, List<List<Integer>> grid){
        Queue<Coordinate> multiSourceBfsQueue = new LinkedList<>();

        int nGrid[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    multiSourceBfsQueue.offer(new Coordinate(i, j));
                    nGrid[i][j] = 0;
                } else {
                    nGrid[i][j] = -1;
                }
            }
        }

        while(!multiSourceBfsQueue.isEmpty()){
            int size = multiSourceBfsQueue.size();
            for(int i = 0; i < size; i++){
                Coordinate coordinate = multiSourceBfsQueue.remove();

                int x = coordinate.x;
                int y = coordinate.y;
                int cellVal = nGrid[x][y];
                for(int direction[] : directions){
                    int dX = x + direction[0];
                    int dY = y + direction[1];

                    if(isValidCell(dX, dY, n) && nGrid[dX][dY] == -1){
                        nGrid[dX][dY] = 1 + cellVal;
                        multiSourceBfsQueue.offer(new Coordinate(dX, dY));
                    }
                }
            }
        }

        return nGrid;
    }

    public static boolean isValidCell(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}