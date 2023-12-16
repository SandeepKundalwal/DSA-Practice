import java.util.Arrays;

public class Main {
    static long MOD = 12345;
    public static void main(String[] args) {
        int grid[][] = {
                {1,2},
                {3,4}
        };
        System.out.println(Arrays.deepToString(constructProductMatrix(grid)));
    }

    public static int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long prefixGrid[][] = new long[n][m];
        long suffixGrid[][] = new long[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i != 0 && j == 0){
                    prefixGrid[i][j] = (prefixGrid[i - 1][m - 1] * grid[i - 1][m - 1]) % MOD;
                } else {
                    if( i == 0 && j == 0){
                        prefixGrid[i][j] = 1;
                    } else {
                        prefixGrid[i][j] = (prefixGrid[i][j - 1] * grid[i][j - 1]) % MOD;
                    }
                }

            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i != n - 1 && j == m - 1){
                    suffixGrid[i][j] = (suffixGrid[i + 1][0] * grid[i + 1][0]) % MOD;
                } else {
                    if(i == n - 1 && j == m - 1){
                        suffixGrid[i][j] = 1;
                    } else {
                        suffixGrid[i][j] = (suffixGrid[i][j + 1] * grid[i][j + 1]) % MOD;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = (int) ((prefixGrid[i][j] * suffixGrid[i][j]) % MOD);
            }
        }

        return grid;
    }
}