public class Main {
    public static void main(String[] args) {
        String num1 = "3876620623801494171";
        String num2 = "6529364523802684779";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0, m = num1.length() - 1, n = num2.length() - 1;

        while(m >= 0 || n >= 0){
            int d1 = m >= 0 ? num1.charAt(m) - '0' : 0;
            int d2 = n >= 0 ? num2.charAt(n) - '0' : 0;

            int sum = d1 + d2 + carry;
            carry =  sum / 10;
            result.append(sum % 10);
            m--;
            n--;
        }

        if(carry > 0){
            result.append(carry);
        }

        return result.reverse().toString();
    }
}