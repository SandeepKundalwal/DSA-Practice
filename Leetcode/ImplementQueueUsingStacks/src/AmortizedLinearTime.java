import java.util.Stack;

public class AmortizedLinearTime {
    Stack<Integer> mainStack;
    Stack<Integer> supportStack;

    public AmortizedLinearTime() {
        this.mainStack = new Stack<>();
        this.supportStack = new Stack();
    }

    public void push(int x) {
        while(!mainStack.isEmpty()){
            supportStack.push(mainStack.pop());
        }

        mainStack.push(x);

        while(!supportStack.isEmpty()){
            mainStack.push(supportStack.pop());
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}
