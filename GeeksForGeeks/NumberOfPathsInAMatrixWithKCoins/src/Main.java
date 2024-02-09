import java.util.Arrays;

public class Main {
    /*
     Given a n x n matrix such that each of its cells contains some coins.
     Count the number of ways to collect exactly k coins while moving from
     top left corner of the matrix to the bottom right. From a cell (i, j),
     you can only move to (i+1, j) or (i, j+1).
     */
    public static void main(String[] args) {
//        int k = 12;
//        int n = 3;
        int k = 3;
        int n = 10;
        int arr[][] = {
                {5, 3, 1, 5, 5, 3, 4, 4, 4, 4},
                {5, 1, 5, 3, 5, 2, 1, 2, 2, 2},
                {2, 1, 3, 1, 4, 2, 5, 2, 2, 1},
                {1, 4, 4, 3, 3, 4, 2, 2, 4, 4},
                {1, 1, 2, 2, 3, 2, 5, 1, 3, 5},
                {1, 1, 2, 3, 5, 1, 4, 4, 2, 2},
                {3, 3, 1, 3, 3, 4, 3, 3, 2, 1},
                {3, 4, 1, 2, 2, 2, 3, 5, 2, 3},
                {1, 2, 2, 1, 5, 5, 1, 3, 4, 1},
                {5, 4, 2, 3, 1, 1, 3, 2, 5, 2}
        };
        System.out.println(numberOfPath(n, k, arr));
    }

    static int directions[][] = {
            {0,1},{1,0}
    };
    public static long numberOfPath(int n, int k, int arr[][]) {
        // code here
        long MEMO[][][] = new long[n][n][k + 1];
        for(long twoD[][] : MEMO){
            for(long oneD[] : twoD){
                Arrays.fill(oneD, -1);
            }
        }
        return f(0, 0, n, k - arr[0][0] ,arr, MEMO);
    }

    public static long f(int i, int j, int n, int k, int arr[][], long MEMO[][][]){
        if(!insideBoundary(i, j, n)){
            return 0;
        }

        if(k < 0){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            if(k == 0){
                return 1;
            }
            return 0;
        }

        if(MEMO[i][j][k] != -1){
            return MEMO[i][j][k];
        }

        long count = 0;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(insideBoundary(dI, dJ, n)){
                count += f(dI, dJ, n, k - arr[dI][dJ], arr, MEMO);
            }
        }
        return MEMO[i][j][k] = count;
    }

    public static boolean insideBoundary(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }

}