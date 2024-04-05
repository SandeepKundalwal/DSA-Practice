import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "NAanorRoOrROwnTNW";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        if(s.length() <= 1) return s;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && (stack.peek() - 'a' == c - 'A' || stack.peek() - 'A' == c - 'a')){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}