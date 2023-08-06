public class Tabulation {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums[] = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }

        int DP[][] = new int[n + 2][n + 2];

        for(int i = n; i > 0; i--){
            for(int j = 0; j <= n; j++){
                if(i > j){
                    continue;
                }

                int maxCoins = Integer.MIN_VALUE;
                for(int idx = i; idx <= j; idx++){
                    int coins = (newNums[i - 1] * newNums[idx] * newNums[j + 1]) + DP[i][idx - 1] + DP[idx + 1][j];
                    maxCoins = Math.max(maxCoins, coins);
                }

                DP[i][j] = maxCoins;
            }
        }
        return DP[1][n];
    }
}
