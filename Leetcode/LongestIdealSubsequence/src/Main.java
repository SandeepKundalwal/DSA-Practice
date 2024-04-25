import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {
        int n = s.length();
        int MEMO[][] = new int[n][127];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        return f(0, '$', s, k, MEMO);
    }

    public static int f(int idx, int prevChar, String s, int k, int MEMO[][]){
        if(idx >= s.length()){
            return 0;
        }

        if(MEMO[idx][prevChar] != -1){
            return MEMO[idx][prevChar];
        }

        int leaveCount = 0 + f(idx + 1, prevChar, s, k, MEMO);

        int takeCount = 0;
        if(prevChar == '$' || Math.abs(prevChar - (s.charAt(idx))) <= k){
            takeCount = 1 + f(idx + 1, s.charAt(idx), s, k, MEMO);
        }

        return MEMO[idx][prevChar] = Math.max(leaveCount, takeCount);
    }
}