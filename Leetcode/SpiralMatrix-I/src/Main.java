import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if(matrix.length == 0) return result;

        int colEnd = matrix[0].length - 1;
        int rowEnd = matrix.length - 1;
        int row = 0, col = 0;

        while(row <= rowEnd && col <= colEnd){
            for(int i = col; i <= colEnd; i++){
                result.add(matrix[row][i]);
            }
            row++;

            for(int i = row; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(row <= rowEnd){
                for(int i = colEnd; i >= col; i--){
                    result.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            if(col <= colEnd){
                for(int i = rowEnd; i >= row; i--){
                    result.add(matrix[i][col]);
                }
            }
            col++;
        }

        return result;
    }
}