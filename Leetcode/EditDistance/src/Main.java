public class Main {
    public static void main(String[] args) {
        System.out.println("Minimum Distance: " + minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int MEMO[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                MEMO[i][j] = -1;
            }
        }

        return f(m - 1, n - 1, word1, word2, MEMO);
    }

    private static int f(int i, int j, String word1, String word2, int MEMO[][]){
        if(i < 0 && j < 0){
            return 0;
        }

        if(i < 0 || j < 0){
            if(i < 0){
                return j + 1;
            } else {
                return i + 1;
            }
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int mini = Integer.MAX_VALUE, insert = Integer.MAX_VALUE, delete = Integer.MAX_VALUE, replace = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            mini = 0 + f(i - 1, j - 1, word1, word2, MEMO);
        } else {
            insert = 1 + f(i, j - 1, word1, word2, MEMO);
            delete = 1 + f(i - 1, j, word1, word2, MEMO);
            replace = 1 + f(i - 1, j - 1, word1, word2, MEMO);
        }

        return MEMO[i][j] = Math.min(mini, Math.min(insert, Math.min(delete, replace)));
    }
}