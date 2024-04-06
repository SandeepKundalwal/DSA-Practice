import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        char sArr[] = new char[s.length()];
        Arrays.fill(sArr, '$');

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(i);
            } else if (c == ')'){
                if(!stack.isEmpty()){
                    sArr[stack.pop()] = '(';
                    sArr[i] = ')';
                }
            } else {
                sArr[i] = c;
            }
        }

        // System.out.println(Arrays.toString(sArr));

        StringBuilder sb = new StringBuilder();
        for(char c : sArr){
            if(c != '$') sb.append(c);
        }

        return sb.toString();
    }
}