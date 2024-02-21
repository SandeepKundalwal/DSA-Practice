public class Main {
    public static void main(String[] args) {
        int n = 7;
        String s = "T|T&F^T";
        System.out.println(countWays(n, s));
    }

    static int MOD = 1003;
    static int countWays(int n, String s){
        int MEMO[][][] = new int[n][n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 2; k++){
                    MEMO[i][j][k] = -1;
                }
            }
        }
        return f(0, n - 1, 1, s, MEMO);
    }

    public static int f(int start, int end, int isTrue, String s, int MEMO[][][]){
        if(start > end){
            return 0;
        }

        if(start == end){
            if(isTrue == 1) {
                return (s.charAt(start) == 'T') ? 1 : 0;

            } else {
                return (s.charAt(start) == 'F') ? 1 : 0;
            }
        }

        if(MEMO[start][end][isTrue] != -1){
            return MEMO[start][end][isTrue];
        }

        int ways = 0;
        for(int k = start + 1; k <= end - 1; k += 2){
            int rT = f(start, k - 1, 1, s, MEMO);
            int rF = f(start, k - 1, 0, s, MEMO);
            int lT = f(k + 1, end, 1, s, MEMO);
            int lF = f(k + 1, end, 0, s, MEMO);

            char c = s.charAt(k);
            if(c == '&'){
                if(isTrue == 1) {
                    ways = ((ways % MOD) + (rT * lT) % MOD) % MOD;
                } else {
                    ways = ((ways % MOD) + ((rT * lF) % MOD) + ((rF * lT) % MOD) + ((rF * lF) % MOD)) % MOD;
                }
            } else if(c == '|'){
                if(isTrue == 1) {
                    ways = ((ways % MOD) + ((rT * lF) % MOD) + ((rF * lT) % MOD) + ((rT * lT) % MOD)) % MOD;
                } else {
                    ways = ((ways % MOD) + ((rF * lF) % MOD)) % MOD;
                }
            } else {
                if(isTrue == 1) {
                    ways = ((ways % MOD) + ((rT * lF) % MOD) + ((rF * lT) % MOD)) % MOD;
                } else {
                    ways = ((ways % MOD) + ((rT * lT) % MOD) + ((rF * lF) % MOD)) % MOD;
                }
            }
        }

        return MEMO[start][end][isTrue] = ways;
    }
}