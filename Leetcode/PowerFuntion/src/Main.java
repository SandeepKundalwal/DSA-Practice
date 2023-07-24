public class Main {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println("Math.pow(" + x + ", " + n + "): " + myPow(x, n));
    }

    /**
     1. if n < 0, we have to do 1 / result -> DONE
     2. if n is odd, multiply the result with x -> DONE
     */
    public static double myPow(double x, int n) {
        return n < 0 ? 1 / findPow(x, n) : findPow(x, n);
    }

    public static double findPow(double x, int n){
        if( n == 0){
            return 1.0;
        }

        return findPow(x * x, n / 2) * (n % 2 == 0 ? 1 : x);
    }
}