import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(sadd));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(isOpenBracket(ch)){
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;

                char topCh = stack.pop();
                if(ch == ')' && topCh != '('){
                    return false;
                } else if(ch == ']' && topCh != '['){
                    return false;
                } else if(ch == '}' && topCh != '{'){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static boolean isOpenBracket(char ch){
        return ch == '(' || ch == '[' || ch == '{';
    }
}