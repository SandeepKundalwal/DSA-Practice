import java.util.ArrayList;
import java.util.List;

public class MinStack {
    int top;
    Long mini;
    List<Long> stack;

    public MinStack() {
        this.top = -1;
        this.mini = Long.MAX_VALUE;
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        Long longVal = Long.valueOf(val);
        if(stack.isEmpty()){
            mini = longVal;
        } else if(longVal < mini){
            Long newMini = longVal;
            longVal = 2 * longVal - mini;
            mini = newMini;
        }

        stack.add(longVal);
        top++;
    }

    public void pop() {
        if(top < 0){
            return;
        }

        if(stack.get(top) < mini){
            mini = 2 * mini - stack.get(top);
        }
        stack.remove(top);
        top--;
    }

    public int top() {
        return stack.get(top) > mini ? stack.get(top).intValue() : mini.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}
