public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recursive:" + Recursive.allPossibleFBT(n));
        System.out.println("Memoization:" + Memoization.allPossibleFBT(n));
    }
}