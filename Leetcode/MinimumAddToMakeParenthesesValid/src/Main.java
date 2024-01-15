import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int minOperations = 0;
        for(char bracket : s.toCharArray()){
            if(bracket == '('){
                stack.push(bracket);
            } else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    minOperations++;
                }
            }
        }

        return minOperations + stack.size();
    }
}