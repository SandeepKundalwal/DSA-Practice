import java.util.Arrays;

public class Memoization {
    public static int maxProfit(int[] prices) {
        int[][] DP = new int[prices.length][2];
        for(int[] row : DP){
            Arrays.fill(row, -1);
        }

        return backtrack(0, 1, prices, DP);
    }

    // @BuyOrSell: 1->Buy; 0->Sell
    public static int backtrack(int index, int BuyOrSell, int[] prices, int[][] DP){
        if(index == prices.length){
            return 0;
        }

        if(DP[index][BuyOrSell] != -1){
            return DP[index][BuyOrSell];
        }

        // if BuyOrSell == 1, then we can buy the current stock or we can skip it; else we can either sell the stock that we have for the
        // current price or we can sell it later
        if(BuyOrSell == 1){
            DP[index][BuyOrSell] = Math.max(-prices[index] + backtrack(index + 1, 0, prices, DP), backtrack(index + 1, 1, prices, DP));
        } else {
            DP[index][BuyOrSell] = Math.max(prices[index] + backtrack(index + 1, 1, prices, DP), backtrack(index + 1, 0, prices, DP));
        }

        return DP[index][BuyOrSell];
    }
}
