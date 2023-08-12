public class Tabulation {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int DP[][] = new int[row + 1][col + 1];

        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(obstacleGrid[i][j] != 1){
                    if(i == row - 1 && j == col - 1){
                        DP[i][j] = 1;
                        continue;
                    }
                    DP[i][j] = DP[i][j + 1] + DP[i + 1][j];
                }
            }
        }

        return DP[0][0];
    }
}
