import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int matrix[][] = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> luckyNumbers = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int mini = 100001, miniIdx = -1;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < mini){
                    mini = matrix[i][j];
                    miniIdx = j;
                }
            }

            int maxi = 0, maxiIdx = -1;
            for(int k = 0; k < m; k++){
                if(maxi < matrix[k][miniIdx]){
                    maxi = matrix[k][miniIdx];
                    maxiIdx = k;
                }
            }

            if(matrix[i][miniIdx] == matrix[maxiIdx][miniIdx]){
                luckyNumbers.add(matrix[i][miniIdx]);
            }
        }

        return luckyNumbers;
    }
}