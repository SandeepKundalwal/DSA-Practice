public class Memoization {
    /**
     buy -> 0
     sell -> 1
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int MEMO[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                MEMO[i][j] = -1;
            }
        }

        return f(0, 0, prices, MEMO);
    }

    public static int f(int idx, int buy, int prices[], int MEMO[][]){
        if(idx >= prices.length){
            return 0;
        }

        if(MEMO[idx][buy] != -1){
            return MEMO[idx][buy];
        }

        int profit = Integer.MIN_VALUE;
        if(buy == 0){
            profit = Math.max(-prices[idx] + f(idx + 1, 1, prices, MEMO), f(idx + 1, 0, prices, MEMO));
        } else {
            profit = Math.max(prices[idx] + f(idx + 2, 0, prices, MEMO), f(idx + 1, 1, prices, MEMO));
        }

        return MEMO[idx][buy] = profit;
    }
}
