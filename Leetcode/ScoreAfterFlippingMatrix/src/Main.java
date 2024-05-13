public class Main {
    public static void main(String[] args) {
        int grid[][] = {
                {0,0,1,1},{1,0,1,0},{1,1,0,0}
        };
        System.out.println(matrixScore(grid));
    }

    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 0){
                for(int j = 0; j < n; j++){
                    grid[i][j] ^= 1;
                }
            }
        }

        for(int j = 0; j < n; j++){
            int countOnes = 0;
            int countZeroes = 0;
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1){
                    countOnes++;
                } else {
                    countZeroes++;
                }
            }

            if(countZeroes > countOnes){
                for(int i = 0; i < m; i++){
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        int maxScore = 0;
        for(int i = 0; i < m; i++){
            int no = 0, twoRaiseToPower = 1;
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] != 0) no += twoRaiseToPower;
                twoRaiseToPower <<= 1;
            }
            maxScore += no;
        }

        return maxScore;
    }
}