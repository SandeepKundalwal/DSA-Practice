import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int MEMO[][] = new int[n + 1][m + 1];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, text1, text2, MEMO);
    }

    public static int f(int n, int m, String text1, String text2, int MEMO[][]){
        if(n < 0 || m < 0){
            return 0;
        }

        if(MEMO[n][m] != -1){
            return MEMO[n][m];
        }

        if(text1.charAt(n) == text2.charAt(m)){
            return MEMO[n][m] = 1 + f(n - 1, m - 1, text1, text2, MEMO);
        } else {
            int leave = Math.max(f(n - 1, m, text1, text2, MEMO), f(n, m - 1, text1, text2, MEMO));
            return MEMO[n][m] = leave;
        }
    }
}