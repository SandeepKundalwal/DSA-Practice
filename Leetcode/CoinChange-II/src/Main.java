public class Main {
    public static void main(String[] args) {
        int amount = 5;
        int coins[] = {1,2,5};
        System.out.println("Memoization: " + Memoization.change(amount, coins));
        System.out.println("Tabulation: " + Tabulation.change(amount, coins));
    }
}