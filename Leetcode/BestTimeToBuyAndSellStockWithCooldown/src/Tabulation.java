public class Tabulation {
    /**
     buy -> 0
     sell -> 1
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int DP[][] = new int[n + 2][2];

        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 1; buy >= 0; buy--){
                int profit = Integer.MIN_VALUE;
                if(buy == 0){
                    profit = Math.max(-prices[idx] + DP[idx + 1][1], DP[idx + 1][0]);
                } else {
                    profit = Math.max(prices[idx] + DP[idx + 2][0], DP[idx + 1][1]);
                }

                DP[idx][buy] = profit;
            }
        }
        return DP[0][0];
    }
}
