public class Main {
    public static void main(String[] args) {
        int prices[] = new int[]{7,1,5,3,6,4};
        System.out.println("Backtracking: " + Backtracking.maxProfit(prices));
        System.out.println("Memoization: " + Memoization.maxProfit(prices));
    }
}