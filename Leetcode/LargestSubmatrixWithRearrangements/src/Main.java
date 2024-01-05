import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int matrix[][] = {
                {0,0,1},
                {1,1,1},
                {1,0,1}
        };
        System.out.println(largestSubmatrix(matrix));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int mat[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0){
                    mat[i][j] = matrix[i][j];
                } else {
                    if(matrix[i][j] == 1){
                        mat[i][j] = 1 + mat[i - 1][j];
                    } else {
                        mat[i][j] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            Arrays.sort(mat[i]);
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = m - 1; j >= 0; j--){
                maxArea = Math.max(maxArea, (m - j) * mat[i][j]);
            }
        }

        return maxArea;
    }
}