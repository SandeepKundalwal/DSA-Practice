import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int rowSum[] = {5,7,10};
        int colSum[] = {8,6,8};
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum, colSum)));
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int matrix[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // System.out.println(rowSum[i] + " " + colSum[j]);
                if(rowSum[i] == 0 || colSum[j] == 0){
                    continue;
                }

                if(rowSum[i] < colSum[j]){
                    matrix[i][j] = rowSum[i];
                    colSum[j] -= rowSum[i];
                    rowSum[i] = 0;
                } else {
                    matrix[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                    colSum[j] = 0;
                }
            }
        }

        return matrix;
    }
}