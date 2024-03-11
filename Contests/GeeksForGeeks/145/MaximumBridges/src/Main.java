import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int a[] = {1,1,2,1};
        int b[] = {1,2,1,2,1};
        System.out.println(maximumBridges(n, m, a, b));
    }

    public static int maximumBridges(int n, int m, int[] a, int[] b) {
        // code here
        int MEMO[][] = new int[n][m];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, a, b, MEMO);
    }

    public static int f(int i, int j, int a[], int b[], int MEMO[][]){
        if(i < 0) return 0;
        if(j < 0) return 0;

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        if(a[i] == b[j]){
            return MEMO[i][j] = 1 + f(i - 1, j - 1, a, b, MEMO);
        } else {
            int l = f(i - 1, j, a, b, MEMO);
            int m = f(i, j - 1, a, b, MEMO);

            return MEMO[i][j] = Math.max(l, m);
        }
    }
}