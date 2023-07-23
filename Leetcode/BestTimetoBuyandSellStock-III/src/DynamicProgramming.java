public class DynamicProgramming {
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int n = prices.length;
        int DP[][][] = new int[n + 1][2][3];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int capacity = 1; capacity <= 2; capacity++) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-prices[idx] + DP[idx + 1][0][capacity], DP[idx + 1][1][capacity]);
                    } else {
                        profit = Math.max(prices[idx] + DP[idx + 1][1][capacity - 1], DP[idx + 1][0][capacity]);
                    }

                    DP[idx][buy][capacity] = profit;
                }
            }
        }
        return DP[0][1][2];
    }
}
