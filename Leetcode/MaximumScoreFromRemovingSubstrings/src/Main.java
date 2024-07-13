import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "abbaab";
        int x = 1;
        int y = 100;
        System.out.println(maximumGain(s, x, y));
        System.out.println("Using Stack: " + maximumGainUsingStack(s, x, y));
    }

    /*
    Better Space Complexity
     */
    public static int maximumGain(String s, int x, int y) {
        StringBuilder newS = new StringBuilder(s);

        return x > y ?  f(newS, x, new char[]{'a', 'b'}) + f(newS, y, new char[]{'b', 'a'}) :
                f(newS, y, new char[]{'b', 'a'}) + f(newS, x, new char[]{'a', 'b'});
    }

    public static int f(StringBuilder newS, int point, char neededS[]){
        int n = newS.length();

        int score = 0, wIdx = 0;
        for(int rIdx = 0; rIdx < n; rIdx++){
            newS.setCharAt(wIdx++, newS.charAt(rIdx));

            if(wIdx > 1 && newS.charAt(wIdx - 2) == neededS[0] && newS.charAt(wIdx - 1) == neededS[1]){
                wIdx -= 2;
                score += point;
            }
        }

        newS.setLength(wIdx);
        return score;
    }

    /*
    Using Stack
     */
    public static int maximumGainUsingStack(String s, int x, int y) {
        return x > y ? fUsingStack(s, x, y, 'a', 'b') : fUsingStack(s, y, x, 'b', 'a');
    }

    public static int fUsingStack(String s, int max, int min, char first, char second){
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