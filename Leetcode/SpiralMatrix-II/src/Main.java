import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int t) {
        int[][] spiralMatrix = new int[t][t];
        int i = 1, j = 0, k = 0, l = t - 1, m = t - 1, n = 0;
        while(i <= t * t){
            while(j <= l){
                spiralMatrix[k][j] = i++;
                j++;
            }
            k++;
            j = k;

            while(j <= m){
                spiralMatrix[j][l] = i++;
                j++;
            }
            l--;
            j = l;

            while(j >= n){
                spiralMatrix[m][j] = i++;
                j--;
            }
            m--;
            j = m;

            while(j >= k){
                spiralMatrix[j][n] = i++;
                j--;
            }
            n++;
            j = n;
        }
        return spiralMatrix;
    }
}