public class Main {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    /**
     * No loop
     */
    public static boolean isPowerOfTwo(int n) {
        /**
         n == 2^n -> logn == n in base 2
         log(base 2)n = log(base e)n / log(base e)2
         */

        if(n <= 0){
            return false;
        }

        int log = (int)(Math.log(n) / Math.log(2));
        return n == (Math.pow(2, log));
    }

    /**
     * Loop Method
     */
    public static boolean isPowerOfTwoLoop(int n) {
        if(n == 1){
            return true;
        }

        int cnt = 0;
        for(int i = 0; i < 31; i++){
            if((n & (1 << i)) == n){
                cnt++;
            }
        }
        return cnt == 1;
    }
}