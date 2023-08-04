public class selfCode {
    public static int strangePrinter(String s) {
        if(s.length() == 1){
            return 1;
        }

        int n = s.length();
        int MEMO[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                MEMO[i][j] = -1;
            }
        }

        return f(0, n - 1, s, MEMO);
    }

    public static int f(int i, int j, String s, int MEMO[][]){
        if(i == j){
            return 1;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int minTurns = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            minTurns = Math.min(minTurns, f(i, k, s, MEMO) + f(k + 1, j, s, MEMO));
        }

        return MEMO[i][j] = (s.charAt(i) == s.charAt(j) ? minTurns - 1 : minTurns);
    }
}
