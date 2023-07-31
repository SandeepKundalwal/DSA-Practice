public class Memoization {
    /**
     LCS Most Probabily.
     */
    public static int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int MEMO[][] = new int[n1][n2];

        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                MEMO[i][j] = -1;
            }
        }

        return f(n1 - 1, n2 - 1, s1, s2, MEMO);
    }

    public static int f(int i, int j, String s1, String s2, int MEMO[][]){
        if(i == -1 || j == -1){
            if(i == -1 && j == -1){
                return 0;
            }

            int score = 0;
            while(i != -1){
                score += (int)s1.charAt(i--);
            }

            while(j != -1){
                score += (int)s2.charAt(j--);
            }

            return score;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return 0 + f(i - 1, j -1, s1, s2, MEMO);
        }

        return MEMO[i][j] = Math.min((int)s1.charAt(i) + f(i - 1, j, s1, s2, MEMO) , (int)s2.charAt(j) + f(i, j - 1, s1, s2, MEMO));
    }
}
