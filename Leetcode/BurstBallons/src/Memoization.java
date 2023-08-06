public class Memoization {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums[] = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }

        int MEMO[][] = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                MEMO[i][j] = -1;
            }
        }
        return f(1, n, newNums, MEMO);
    }

    public static int f(int i, int j, int newNums[], int MEMO[][]){
        if(i > j){
            return 0;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int maxCoins = Integer.MIN_VALUE;
        for(int idx = i; idx <= j; idx++){
            int coins = (newNums[i - 1] * newNums[idx] * newNums[j + 1]) + f(i, idx - 1, newNums, MEMO) + f(idx + 1, j, newNums, MEMO);
            maxCoins = Math.max(maxCoins, coins);
        }

        return MEMO[i][j] = maxCoins;
    }
}
