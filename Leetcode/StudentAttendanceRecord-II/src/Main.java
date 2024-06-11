import java.util.Arrays;

public class Main {
    static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        int n = 10101;
        System.out.println(checkRecord(n));
    }
    public static int checkRecord(int n) {
        int MEMO[][][] = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(MEMO[i][j], -1);
            }
        }
        return f(0, 0, 0, n, MEMO);
    }

    public static int f(int idx, int absent, int leave, int n, int MEMO[][][]){
        if(idx >= n){
            return 1;
        }

        if(absent >= 2 || leave >= 3) {
            return 0;
        }

        if(MEMO[idx][absent][leave] != -1){
            return MEMO[idx][absent][leave];
        }

        int answer = 0;

        answer = (answer + f(idx + 1, absent, 0, n, MEMO)) % MOD;

        if(absent < 1){
            answer = (answer + f(idx + 1, absent + 1, 0, n, MEMO)) % MOD;
        }

        if(leave < 2){
            answer = (answer + f(idx + 1, absent, leave + 1, n, MEMO)) % MOD;
        }

        return MEMO[idx][absent][leave] = answer;
    }
}