import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char matrix[][] = {{'0','1'},{'1','0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int MEMO[][] = new int[matrix.length][matrix[0].length];

        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        int maxi = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    maxi = Math.max(maxi, f(i, j, matrix, MEMO));
                }
            }
        }

        return maxi * maxi;
    }

    public static int f(int i, int j, char matrix[][], int MEMO[][]){
        if(!inside(i, j, matrix) || matrix[i][j] == '0'){
            return 0;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int down = 0;
        int right = 0;
        int diagonal = 0;
        if(matrix[i][j] == '1'){
            down      = 1 + f(i + 1, j, matrix, MEMO);
            right     = 1 + f(i, j + 1, matrix, MEMO);
            diagonal  = 1 + f(i + 1, j + 1, matrix, MEMO);
        }

        return MEMO[i][j] = Math.min(down, Math.min(right, diagonal));
    }

    public static boolean inside(int i, int j, char matrix[][]){
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}