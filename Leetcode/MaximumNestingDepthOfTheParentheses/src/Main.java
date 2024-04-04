import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int maxi = 0;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else {
                if(c == ')'){
                    maxi = Math.max(maxi, stack.size());
                    stack.pop();
                }
            }
        }

        return maxi;
    }
}