public class Main {
    static int directions[][] = {
            {-1,0},{0,1},{1,0},{0,-1}
    };
    public static void main(String[] args) {
        int grid[][] = {
                {0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}
        };
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // first & last row
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 0){
                runDFS(0, j, grid);
            }

            if(grid[n - 1][j] == 0){
                runDFS(n - 1, j, grid);
            }
        }

        // first & last col
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 0){
                runDFS(i, 0, grid);
            }

            if(grid[i][m - 1] == 0){
                runDFS(i, m - 1, grid);
            }
        }

        int closedIslands = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(grid[i][j] == 0){
                    closedIslands++;
                    runDFS(i, j, grid);
                }
            }
        }

        return closedIslands;
    }

    public static void runDFS(int i, int j, int grid[][]){
        grid[i][j] = 1;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(isCellValid(dI, dJ, grid) && grid[dI][dJ] == 0){
                runDFS(dI, dJ, grid);
            }
        }
    }

    public static boolean isCellValid(int i, int j, int grid[][]){
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}