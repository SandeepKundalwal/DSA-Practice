import java.util.Arrays;

public class Memoization {
    static int directions[][] = new int[][]{
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}
    };
    public static double knightProbability(int n, int k, int row, int column) {
        if(k == 0){
            return 1.0;
        }

        double MEMO[][][] = new double[n][n][k + 1];

        for(double[][] i : MEMO){
            for(double[] j : i){
                Arrays.fill(j, -1);
            }
        }

        return backtrack(row, column, 1.0, k, n, MEMO);
    }

    public static double backtrack(int row, int col, double finalProbablity, int k, int n, double MEMO[][][]){
        if(k == 0){
            return 1.0;
        }

        if(MEMO[row][col][k] != -1){
            return MEMO[row][col][k];
        }

        double probablity = 0.0;
        for(int direction[] : directions){
            int dRow = row + direction[0];
            int dCol = col + direction[1];


            if(insideBoard(dRow, dCol, n)){
                probablity += backtrack(dRow, dCol, finalProbablity, k - 1, n, MEMO);
            }
        }

        finalProbablity *= (probablity / 8);

        return MEMO[row][col][k] = finalProbablity;
    }

    public static boolean insideBoard(int row, int col, int n){
        if(row < 0 || row >= n || col < 0 || col >= n){
            return false;
        }
        return true;
    }
}
