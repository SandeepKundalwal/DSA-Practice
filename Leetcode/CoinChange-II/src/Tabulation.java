import java.util.Arrays;

public class Tabulation {
    public static int change(int amount, int[] coins) {
        int DP[][] = new int[coins.length + 1][amount + 1];

        for(int i = 0; i <= coins.length; i++){
            DP[i][0] = 1;
        }

        for(int idx = coins.length - 1; idx >= 0; idx--){
            for(int currAmount = 0; currAmount <= amount; currAmount++){
                int dontTake = DP[idx + 1][currAmount];
                int take = 0;
                if(coins[idx] <= currAmount){
                    take = DP[idx][currAmount - coins[idx]];
                }

                DP[idx][currAmount] = take + dontTake;
            }
        }

        return DP[0][amount];
    }
}
