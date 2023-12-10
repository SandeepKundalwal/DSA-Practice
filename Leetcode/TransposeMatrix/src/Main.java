public class Main {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6}
        };
        System.out.println(transpose(matrix));
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int transposedMatrix[][] = new int[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}