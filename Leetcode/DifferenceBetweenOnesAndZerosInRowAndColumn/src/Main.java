import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int grid[][] = {{0,1,1},{1,0,1},{0,0,1}};
        System.out.println(Arrays.deepToString(onesMinusZeros(grid)));
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        String rowSum[] = new String[n];
        String colSum[] = new String[m];

        for(int i = 0; i < n; i++){
            int onesRowI = 0, zeroesRowI = 0;
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    zeroesRowI += 1;
                } else {
                    onesRowI += 1;
                }
            }
            rowSum[i] = zeroesRowI + "-" + onesRowI;
        }

        for(int j = 0; j < m; j++){
            int onesColJ = 0, zeroesColJ = 0;
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 0){
                    zeroesColJ += 1;
                } else {
                    onesColJ += 1;
                }
            }

            colSum[j] = zeroesColJ + "-" + onesColJ;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                String pairI[] = rowSum[i].split("-");
                int zeroesRowI = Integer.parseInt(pairI[0]);
                int onesRowI = Integer.parseInt(pairI[1]);
                String pairJ[] = colSum[j].split("-");
                int zeroesColJ = Integer.parseInt(pairJ[0]);
                int onesColJ = Integer.parseInt(pairJ[1]);
                grid[i][j] = differenceEquation(onesRowI, onesColJ, zeroesRowI, zeroesColJ);
            }
        }

        return grid;
    }

    public static int differenceEquation(int onesRowI, int onesColJ, int zeroesRowI, int zeroesColJ){
        return onesRowI + onesColJ - zeroesRowI - zeroesColJ;
    }
}