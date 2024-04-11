import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        Stack<Integer> stack = new Stack<>();

        int countNonZero = 0;
        for(char c : num.toCharArray()){
            int digit = c - '0';

            while(!stack.isEmpty() && stack.peek() > digit && k > 0){
                k--;
                stack.pop();
            }

            if(stack.isEmpty() && digit == 0){
                continue;
            }

            stack.push(digit);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            if(k > 0){
                stack.pop();
                k--;
                continue;
            }
            sb.append(stack.pop());
        }

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}