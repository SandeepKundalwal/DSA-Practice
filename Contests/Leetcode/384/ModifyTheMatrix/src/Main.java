import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,-1},{4,-1,6},{7,8,9}
        };
        System.out.println(Arrays.deepToString(modifiedMatrix(matrix)));
    }

    public static int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxColumn[] = new int[n];
        for(int col = 0; col < n; col++){
            for(int row = 0; row < m; row++){
                maxColumn[col] = Math.max(maxColumn[col], matrix[row][col]);
            }
        }

        int answer[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    answer[i][j] = maxColumn[j];
                } else {
                    answer[i][j] = matrix[i][j];
                }
            }
        }

        return answer;
    }
}