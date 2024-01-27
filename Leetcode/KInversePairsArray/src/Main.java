public class Main {
    static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        int n = 1000;
        int k = 1000;
        System.out.println(kInversePairs(n, k));
    }

    public static int kInversePairs(int n, int k) {
        int DP[][] = new int[n + 1][k + 1];

        DP[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){
                if(j == 0){
                    DP[i][j] = 1;
                    continue;
                }

                DP[i][j] = (DP[i - 1][j] % MOD + DP[i][j - 1] % MOD) % MOD;
                if(j >= i){
                    DP[i][j] = (DP[i][j] - DP[i - 1][j - i] + MOD) % MOD;
                }
            }
        }
        return DP[n][k];
    }
}