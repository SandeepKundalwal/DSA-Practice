public class Main {
    public static void main(String[] args) {
        int nums[] = {3, 1, 5, 8};
        System.out.println("Memoization: " + Memoization.maxCoins(nums));
        System.out.println("Tabulation: " + Tabulation.maxCoins(nums));
    }
}