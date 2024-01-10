import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int amount = 11;
        int coins[] = {1,2,5};
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int MEMO[][] = new int[coins.length][amount + 1];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        int coinsNeeded = f(0, coins, amount, MEMO);
        return coinsNeeded == (int) 1e6 ? -1 : coinsNeeded;
    }

    public static int f(int idx, int coins[], int amount, int MEMO[][]){
        if(amount == 0){
            return 0;
        }

        if(idx >= coins.length){
            return (int)1e6;
        }

        if(MEMO[idx][amount] != -1){
            return MEMO[idx][amount];
        }

        int leaveCoin = 0 + f(idx + 1, coins, amount, MEMO);
        int takeCoin = (int)1e6;
        if(amount - coins[idx] >= 0){
            takeCoin = Math.min(takeCoin, 1 + f(idx, coins, amount - coins[idx], MEMO));
        }

        return MEMO[idx][amount] = Math.min(leaveCoin, takeCoin);
    }
}