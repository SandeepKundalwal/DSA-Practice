import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Memoization: " + minStepsMemoization(15));
    }

    public static int minStepsMemoization(int n) {
        if(n == 1) return 0;

        int MEMO[][] = new int[n][n];
        for(int oneD[] : MEMO){
            Arrays.fill(oneD, -1);
        }

        return 1 + fMemoization(1, 1, n, MEMO);
    }

    public static int fMemoization(int total, int copied, int n, int MEMO[][]){
        if(total > n){
            return (int)1e6;
        }

        if(total == n){
            return 0;
        }

        if(MEMO[total][copied] != -1){
            return MEMO[total][copied];
        }

        int copyOperation = (int)1e6;
        if(total != copied){
            copyOperation = 1 + fMemoization(total, total, n, MEMO);
        }

        int pasteOperation = 1 + fMemoization(total + copied, copied, n, MEMO);

        return MEMO[total][copied] = Math.min(copyOperation, pasteOperation);
    }
}