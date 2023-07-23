public class Recursion {
    public static int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        int n = prices.length;

        return f(0, 1, 2, n, prices);
    }

    public static int f(int idx, int buy, int capacity, int n, int[] prices){
        if(idx == n || capacity == 0){
            return 0;
        }

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx] + f(idx + 1, 0, capacity, n, prices), f(idx + 1, 1, capacity, n, prices));
        } else {
            profit = Math.max(prices[idx] + f(idx + 1, 1, capacity - 1, n, prices), f(idx + 1, 0, capacity, n, prices));
        }

        return profit;
    }
}
