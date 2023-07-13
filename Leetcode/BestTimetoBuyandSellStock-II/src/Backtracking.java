public class Backtracking {
    static int maxProfit = 0;
    public static int maxProfit(int[] prices) {
        backtrack(0, 0, prices);
        return maxProfit;
    }

    public static void backtrack(int index, int profitSoFar, int[] prices){
        if(index == prices.length){
            return;
        }

        for(int i = index; i < prices.length; i++){
            int currentStock = prices[i];
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] < currentStock){
                    continue;
                }
                profitSoFar += (prices[j] - currentStock);
                maxProfit = Math.max(maxProfit, profitSoFar);
                backtrack(j + 1, profitSoFar, prices);
                profitSoFar -= (prices[j] - currentStock);
            }
        }
    }
}
