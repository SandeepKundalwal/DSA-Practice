import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }

    /********************************************************************************************************/
    /*
        Optimal Approach
     */
    public static int numSteps(String s) {
        int n = s.length();

        int steps = 0, carry = 0;
        for(int i = n - 1; i > 0; i--){
            if(((s.charAt(i) - '0') + carry) % 2 == 1){
                // odd and right shift together;
                steps += 2;
                carry = 1;
            } else {
                // just right shift;
                steps += 1;
                carry = ((s.charAt(i) - '0') + carry) / 2;
            }
        }

        return steps + carry;
    }

    /********************************************************************************************************/
    /*
        BigInteger Approach
     */
    public static int numStepsBigIntegerAppraoch(String s) {
        BigInteger bI = new BigInteger(s, 2);
        BigInteger bIOne = new BigInteger("1");
        BigInteger bITwo = new BigInteger("2");

        int steps = 0;
        while(!bI.equals(BigInteger.ONE)){
            if(bI.mod(bITwo).equals(BigInteger.ZERO)){
                bI = bI.divide(bITwo);
            } else {
                bI = bI.add(bIOne);
            }
            steps++;
        }

        return steps;
    }

    /********************************************************************************************************/
    /*
        String Manipulation Approach
     */
    public static int numStepsStringManipulationApproach(String s) {
        int steps = 0;

        while(!isOne(s)){
            s = s.charAt(s.length() - 1) == '1' ? addOne(s) : rightShift(s);
            steps++;
        }

        return steps;
    }

    public static boolean isOne(String s){
        int n = s.length();
        if(s.charAt(n - 1) == '0') return false;

        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '1') return false;
        }

        return true;
    }

    public static String addOne(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int carry = 1;
        for(int i = n - 1; i >= 0; i--){
            int sum = (s.charAt(i) - '0') + carry;

            if(sum == 2){
                sb.append('0');
                carry = 1;
            } else {
                sb.append(String.valueOf(sum));
                carry = 0;
            }
        }

        if(carry == 1){
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static String rightShift(String s){
        int n = s.length();
        return "0" + s.substring(0, n - 1);
    }
}