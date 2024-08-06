public class Main {
    public static void main(String[] args) {
        int grid[][] = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(minFlips(grid));
    }

    public static int minFlips(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int flips = 0;
        for(int i = 0; i < rows / 2; i++){
            for(int j = 0; j < cols / 2; j++){
                int k = rows - 1 - i;
                int l = cols - 1 - j;

                int LT = grid[i][j];
                int LB = grid[k][j];
                int RT = grid[i][l];
                int RB = grid[k][l];
                int countOnes = LT + LB + RT + RB;

                flips += Math.min(countOnes, 4 - countOnes);
            }
        }

        int ones = 0;
        int flipsInMid = 0;
        if(rows % 2 != 0){
            int i = rows / 2;
            for(int j = 0; j < cols / 2; j++){
                if(grid[i][j] != grid[i][cols - 1 - j]){
                    flips++;
                    flipsInMid++;
                }

                if(grid[i][j] == grid[i][cols - 1 - j] && grid[i][j] == 1){
                    ones += 2;
                }
            }
        }

        if(cols % 2 != 0){
            int j = cols / 2;
            for(int i = 0; i < rows / 2; i++){
                if(grid[i][j] != grid[rows - 1 - i][j]){
                    flips++;
                    flipsInMid++;
                }

                if(grid[i][j] == grid[rows - 1 - i][j] && grid[i][j] == 1){
                    ones += 2;
                }
            }
        }

        if(rows % 2 != 0 && cols % 2 != 0 && grid[rows / 2][cols / 2] == 1){
            flips++;
        }

        if((ones % 4) != 0 && flipsInMid == 0){
            flips += 2;
        }

        return flips;
    }
}