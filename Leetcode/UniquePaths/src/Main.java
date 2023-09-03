public class Main {
    private static final int[][] directions = {
            {0, 1}, {1, 0}
    };
    public static void main(String[] args) {
        int m = 20;
        int n = 13;
        System.out.println("Number of Unqiue Paths: " + uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        int MEMO[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                MEMO[i][j] = -1;
            }
        }
        return f(0 ,0, m, n, MEMO);
    }

    private static int f(int i, int j, int m, int n, int MEMO[][]){
        if(i == m - 1 && j == n - 1){
            return 1;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int ans = 0;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(isValidMove(dI, dJ, m, n)){
                ans += f(dI, dJ, m, n, MEMO);
            }
        }
        return MEMO[i][j] = ans;
    }

    private static boolean isValidMove(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}