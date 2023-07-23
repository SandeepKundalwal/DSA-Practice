import java.util.Arrays;

public class Memoization {
    public static int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        int n = prices.length;
        int MEMO[][][] = new int[n][2][3];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(MEMO[i][j], -1);
            }
        }

        return f(0, 1, 2, n, prices, MEMO);
    }

    public static int f(int idx, int buy, int capacity, int n, int[] prices, int MEMO[][][]){
        if(idx == n || capacity == 0){
            return 0;
        }

        if(MEMO[idx][buy][capacity] != -1){
            return MEMO[idx][buy][capacity];
        }

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx] + f(idx + 1, 0, capacity, n, prices, MEMO), f(idx + 1, 1, capacity, n, prices, MEMO));
        } else {
            profit = Math.max(prices[idx] + f(idx + 1, 1, capacity - 1, n, prices, MEMO), f(idx + 1, 0, capacity, n, prices, MEMO));
        }

        return MEMO[idx][buy][capacity] = profit;
    }
}
