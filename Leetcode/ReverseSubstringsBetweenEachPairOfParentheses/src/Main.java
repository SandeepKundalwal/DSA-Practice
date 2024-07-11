import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println("Straight-Forward: " + reverseParentheses2(s));
        System.out.println("Wormhole Technique: " + reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        int n = s.length();

        int portals[] = new int[n];
        Stack<Integer> openParenthesis = new Stack<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == '('){
                openParenthesis.push(i);
            } else if(c == ')'){
                int j = openParenthesis.pop();
                portals[i] = j;
                portals[j] = i;
            }
        }

        StringBuilder reversedString = new StringBuilder();

        int direction = 1;
        for(int currIdx = 0; currIdx < n; currIdx += direction){
            char c = s.charAt(currIdx);

            if(c == '(' || c == ')'){
                currIdx = portals[currIdx];
                direction = -direction;
            } else {
                reversedString.append(c);
            }
        }

        return reversedString.toString();
    }

    /*
    Time Complexity: O(n * parenthesis)
     */
    public static String reverseParentheses2(String s) {
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