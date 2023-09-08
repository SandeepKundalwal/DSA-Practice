public class Main {
    public static void main(String[] args) {
        System.out.println("Quotient is: " + divide(8, 3));
    }

    public static int divide(int dividend, int divisor) {
        /**
         1.truncate towards 0
         2.Don't use multiplication, division and mod operator
         3.Return quotient
         4.Range [−2^31, 2^31 − 1] -> if strictly greater than 2^31 - 1 = return 2^31 - 1
         -> if strictly less than -2^31 = return 2^31 - 1
         */

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int quotient = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while(a - b >= 0){
            int power = 0;
            // instead of removing by divisor from dividend, I am basically doubling divisor and checking
            // how many times can i double the divisor without making it larger than dividend
            // (b << 1 << power) is basically doubling the divisor
            while((a - (b << 1 << power)) >= 0){
                power++;
            }
            quotient += (1 << power); // how many times was i able to double the divisor without exceeding the dividend
            a -= (b << power); // remove the value from dividend i.e, how much we were able to double the dividend
        }

        // checking for sign
        return (dividend >= 0) == (divisor >= 0) ? quotient : -quotient;
    }
}