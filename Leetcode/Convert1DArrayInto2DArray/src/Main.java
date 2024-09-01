import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int original[] = {1,2,3,4};
        int m = 2;
        int n = 2;
        System.out.println(Arrays.deepToString(construct2DArray(original, m, n)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n < original.length || original.length < m * n) return new int[0][0];

        int matrix[][] = new int[m][n];

        int idx = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = original[idx++];
            }
        }

        return matrix;
    }
}