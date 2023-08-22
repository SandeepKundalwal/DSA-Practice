import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String tokens[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Ans: " + evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> digits = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int RHS = digits.pop();
                int LHS = digits.pop();
                int ans = 0;
                if(token.equals("+")){
                    ans = LHS + RHS;
                } else if(token.equals("-")) {
                    ans = LHS - RHS;
                } else if(token.equals("*")) {
                    ans = LHS * RHS;
                } else {
                    ans = LHS / RHS;
                }
                digits.push(ans);
            } else {
                digits.push(Integer.parseInt(token));
            }
        }
        return digits.pop();
    }
}