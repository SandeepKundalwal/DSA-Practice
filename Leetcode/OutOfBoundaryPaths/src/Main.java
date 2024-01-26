import java.util.Arrays;

public class Main {
    static int MOD = (int)1e9 + 7;
    static int directions[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) {
        int m = 50;
        int n = 50;
        int maxMove = 50;
        int startRow = 0;
        int startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }


    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MEMO[][][] = new int[m][n][maxMove + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(MEMO[i][j], -1);
            }
        }
        return f(m, n, maxMove, startRow, startColumn, MEMO);
    }

    public static int f(int m, int n, int maxMove, int i, int j, int MEMO[][][]){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return 1;
        }

        if(MEMO[i][j][maxMove] != -1){
            return MEMO[i][j][maxMove];
        }

        int count = 0;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(maxMove > 0){
                count = (count % MOD + f(m, n, maxMove - 1, dI, dJ, MEMO) % MOD) % MOD;
            } else {
                return 0;
            }
        }
        return MEMO[i][j][maxMove] = count;
    }
}