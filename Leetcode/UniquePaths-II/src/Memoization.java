public class Memoization {
    static int directions[][] = {
            {0, 1}, {1, 0}
    };

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int MEMO[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                MEMO[i][j] = -1;
            }
        }

        return countUniquePaths(0, 0, row, col, obstacleGrid, MEMO);
    }

    public static int countUniquePaths(int i, int j, int row, int col, int obstacleGrid[][], int MEMO[][]){
        if(i < 0 || i >= row || j < 0 || j >= col || obstacleGrid[i][j] == 1){
            return 0;
        }

        if(i == row - 1 && j == col - 1){
            return 1;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int cnt = 0;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            cnt += countUniquePaths(dI, dJ, row, col, obstacleGrid, MEMO);
        }

        return MEMO[i][j] = cnt;
    }
}
