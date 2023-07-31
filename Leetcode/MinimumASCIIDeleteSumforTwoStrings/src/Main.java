public class Main {
    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println("Memoization: " + Memoization.minimumDeleteSum(s1, s2));
        System.out.println("Tabulation: " + Tabulation.minimumDeleteSum(s1, s2));
    }
}