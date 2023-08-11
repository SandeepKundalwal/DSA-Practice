public class Memoization {
    public static int change(int amount, int[] coins) {
        int MEMO[][] = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                MEMO[i][j] = -1;
            }
        }
        return findWays(0, amount, coins, MEMO);
    }

    public static int findWays(int index, int amount, int coins[], int MEMO[][]){
        if(index >= coins.length){
            return 0;
        }

        if(amount == 0){
            return 1;
        }

        if(MEMO[index][amount] != -1){
            return MEMO[index][amount];
        }

        int dontTake = findWays(index + 1, amount, coins, MEMO);
        int take = 0;
        if(coins[index] <= amount){
            take = findWays(index, amount - coins[index], coins, MEMO);
        }

        return MEMO[index][amount] = take + dontTake;
    }
}
