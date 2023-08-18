import java.util.Stack;

public class AmortizedConstantTime {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public AmortizedConstantTime() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
