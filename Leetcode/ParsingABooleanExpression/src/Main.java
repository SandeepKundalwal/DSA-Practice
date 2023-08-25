import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String expression = "!(&(f,t))";
        String expression1 = "!(&(!(t),&(f),|(f)))";
        String expression2 = "!(&(!(&(f)),&(t),|(f,f,t)))";
        String expression3 = "!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))"; // -> true
        System.out.println(parseBoolExpr(expression3));
    }

    private static boolean parseBoolExpr(String expression) {
        Stack<Character> others = new Stack<>();
        Stack<Character> operators = new Stack<>();
        char expressionArr[] = expression.toCharArray();

        for(char character : expressionArr){
            if(character == ','){
                continue;
            } else if(character == '(' || character == 't' || character == 'f'){
                others.push(character);
            } else if(character == '!' || character == '&' || character == '|'){
                operators.push(character);
            } else {
                if(operators.peek() == '!'){
                    operators.pop();
                    others.push(evaluateNegation(others));
                } else if(operators.peek() == '&'){
                    operators.pop();
                    others.push(evaluateAND(others));
                } else {
                    operators.pop();
                    others.push(evaluateOR(others));
                }
            }
        }

        return others.pop() == 't';
    }

    private static char evaluateNegation(Stack<Character> stack){
        char finalAns = stack.pop() == 't' ? 'f' : 't';
        stack.pop();
        return finalAns;
    }

    private static char evaluateOR(Stack<Character> stack){
        char finalAns = 'f';
        while(stack.peek() != '('){
            char poppedChar = stack.pop();
            if(poppedChar == 't'){
                finalAns = 't';
            }
        }
        stack.pop();
        return finalAns;
    }

    private static char evaluateAND(Stack<Character> stack){
        char finalAns = 't';
        while(stack.peek() != '('){
            char poppedChar = stack.pop();
            if(poppedChar == 'f'){
                finalAns = 'f';
            }
        }
        stack.pop();
        return finalAns;
    }
}