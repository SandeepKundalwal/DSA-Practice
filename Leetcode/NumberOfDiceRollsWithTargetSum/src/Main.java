import java.util.Arrays;

public class Main {
    static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        int n = 30;
        int k = 30;
        int target = 500;
        System.out.println(numRollsToTarget(n, k, target));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int MEMO[][] = new int[n + 1][target + 1];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        return f(n, k, target, MEMO) % MOD;
    }

    public static int f(int n, int k, int target, int MEMO[][]){
        if(n == 0){
            if(target == 0) return 1;
            return 0;
        }

        if(target < 0){
            return 0;
        }

        if(MEMO[n][target] != -1){
            return MEMO[n][target];
        }

        int cnt = 0;
        for(int i = 1; i <= k; i++){
            cnt = ((cnt % MOD) + (f(n - 1, k, target - i, MEMO) % MOD)) % MOD;
        }

        return MEMO[n][target] = (cnt % MOD);
    }
}