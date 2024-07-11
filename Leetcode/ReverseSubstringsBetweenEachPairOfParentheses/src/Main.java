import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(reverseParentheses(s));
    }

    /*
    Time Complexity: O(n * parenthesis)
     */
    public static String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == ')'){
                Queue<Character> queue = new LinkedList<>();
                while(!stack.isEmpty() && stack.peek() != '('){
                    queue.offer(stack.pop());
                }

                stack.pop();

                while(!queue.isEmpty()){
                    stack.push(queue.remove());
                }

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