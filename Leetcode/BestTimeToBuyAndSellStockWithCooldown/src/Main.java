public class Main {
    public static void main(String[] args) {
        int prices[] = {1, 2, 3, 0, 2};
        System.out.println("Memoization: " + Memoization.maxProfit(prices));
        System.out.println("Tabulation: " + Tabulation.maxProfit(prices));
    }
}