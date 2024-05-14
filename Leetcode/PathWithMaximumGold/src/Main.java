public class Main {
    static int directions[][] = {
            {-1,0},{0,1},{1,0},{0,-1}
    };
    public static void main(String[] args) {
        int grid[][] = {
                {0,6,0},{5,8,7},{0,9,0}
        };
        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxi = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    maxi = Math.max(maxi, grid[i][j] + f(i, j, grid));
                }
            }
        }
        return maxi;
    }

    public static int f(int i, int j, int grid[][]){
        int originalGold = grid[i][j];
        grid[i][j] = 0;

        int coinsCollected = 0;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(insideGrid(dI, dJ, grid) && grid[dI][dJ] != 0){
                coinsCollected = Math.max(coinsCollected, grid[dI][dJ] + f(dI, dJ, grid));
            }
        }

        grid[i][j] = originalGold;

        return coinsCollected;
    }

    public static boolean insideGrid(int i, int j, int grid[][]){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}