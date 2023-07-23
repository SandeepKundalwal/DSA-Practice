public class Main {
    public static void main(String[] args) {
        /**
         * PROBLEM STATEMENT
         * You are given an array prices where prices[i] is the price of a given stock on the ith day.
         * Find the maximum profit you can achieve. You may complete at most two transactions.
         * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
         */
        int prices[] = {3,3,5,0,0,3,1,4};
        System.out.println("Recursion: " + Recursion.maxProfit(prices));
        System.out.println("Memoization: " + Memoization.maxProfit(prices));
        System.out.println("Dynamic Programming: " + DynamicProgramming.maxProfit(prices));
        System.out.println("Dynamic Programming Constant Space: " + DynamicProgrammingConstantSpace.maxProfit(prices));
    }
}