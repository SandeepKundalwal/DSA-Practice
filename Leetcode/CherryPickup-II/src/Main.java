public class Main {
    static int directions[][] = {
            {1, -1}, {1, 0}, {1, 1}
    };
    public static void main(String[] args) {
        int grid[][] = {
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };
        System.out.println(cherryPickup(grid));
    }

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int MEMO[][][][] = new int[m][n][m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    for(int l = 0; l < n; l++){
                        MEMO[i][j][k][l] = -1;
                    }
                }
            }
        }
        return grid[0][0] + grid[0][n - 1] + f(0, 0, 0, n - 1, m, n, grid, MEMO);
    }

    public static int f(int i1, int j1, int i2, int j2, int m, int n, int grid[][], int MEMO[][][][]){
        if(i1 >= m && i2 >= n){
            return 0;
        }

        if(MEMO[i1][j1][i2][j2] != -1){
            return MEMO[i1][j1][i2][j2];
        }

        int maxi = 0;
        for(int direction1[] : directions){
            int dI1 = i1 + direction1[0];
            int dJ1 = j1 + direction1[1];

            if(insideBoundary(dI1, dJ1, m, n)){
                for(int direction2[] : directions){
                    int dI2 = i2 + direction2[0];
                    int dJ2 = j2 + direction2[1];

                    if(insideBoundary(dI2, dJ2, m, n)){
                        int sum = 0;
                        if(dI1 == dI2 && dJ1 == dJ2){
                            sum = grid[dI1][dJ1];
                        } else {
                            sum = (grid[dI1][dJ1] + grid[dI2][dJ2]);
                        }

                        maxi = Math.max(maxi, sum + f(dI1, dJ1, dI2, dJ2, m, n, grid, MEMO));
                    }
                }
            }
        }

        return MEMO[i1][j1][i2][j2] = maxi;
    }

    public static boolean insideBoundary(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}