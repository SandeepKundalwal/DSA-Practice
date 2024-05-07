import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        int n = s.length();
        int MEMO[][] = new int[n][n];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }
        return f(0, n - 1, s, MEMO);
    }

    public static int f(int start, int end, String s, int MEMO[][]){
        if(start >= end){
            return 0;
        }

        if(MEMO[start][end] != -1){
            return MEMO[start][end];
        }

        if(s.charAt(start) == s.charAt(end)){
            return MEMO[start][end] = f(start + 1, end - 1, s, MEMO);
        } else {
            int front = 1 + f(start + 1, end, s, MEMO);
            int  back = 1 + f(start, end - 1, s, MEMO);

            return MEMO[start][end] = Math.min(front, back);
        }
    }
}