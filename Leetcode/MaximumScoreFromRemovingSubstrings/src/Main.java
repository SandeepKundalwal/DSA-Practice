import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "abbaab";
        int x = 1;
        int y = 100;
        System.out.println(maximumGain(s, x, y));
    }

    public static int maximumGain(String s, int x, int y) {
        return x > y ? f(s, x, y, 'a', 'b') : f(s, y, x, 'b', 'a');

    }

    public static int f(String s, int max, int min, char first, char second){
        int score = 0;

        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stk.isEmpty() && stk.peek() == first && c == second){
                score += max;
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);

            if(!stk.isEmpty() && stk.peek() == first && c == second){
                score += min;
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return score;
    }
}