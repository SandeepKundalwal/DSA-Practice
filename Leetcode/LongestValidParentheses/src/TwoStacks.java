import java.util.Stack;

public class TwoStacks {
    public static int longestValidParentheses(String s) {
        int maxi = 0;
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);

        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(character == '('){
                characterStack.push(character);
                indexStack.push(i);
            } else {
                if(!characterStack.isEmpty() && characterStack.peek() == '('){
                    characterStack.pop();
                    indexStack.pop();
                    maxi = Math.max(maxi, i - indexStack.peek());
                } else {
                    indexStack.push(i);
                }
            }
        }
        return maxi;
    }
}
