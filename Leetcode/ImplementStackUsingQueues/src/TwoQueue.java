import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue {
    Queue<Integer> firstQueue;
    Queue<Integer> secondQueue;

    public TwoQueue() {
        this.firstQueue = new LinkedList<>();
        this.secondQueue = new LinkedList<>();
    }

    public void push(int x) {
        firstQueue.offer(x);
    }

    public int pop() {
        if(!firstQueue.isEmpty()){
            int size = firstQueue.size();
            for(int i = 0; i < size - 1; i++){
                secondQueue.offer(firstQueue.remove());
            }
            return firstQueue.remove();
        } else {
            int size = secondQueue.size();
            for(int i = 0; i < size - 1; i++){
                firstQueue.offer(secondQueue.remove());
            }
            return secondQueue.remove();
        }
    }

    public int top() {
        int top = -1;
        if(!firstQueue.isEmpty()){
            int size = firstQueue.size();
            for(int i = 0; i < size - 1; i++){
                secondQueue.offer(firstQueue.remove());
            }
            top = firstQueue.remove();
            secondQueue.offer(top);
        } else {
            int size = secondQueue.size();
            for(int i = 0; i < size - 1; i++){
                firstQueue.offer(secondQueue.remove());
            }
            top = secondQueue.remove();
            firstQueue.offer(top);
        }
        return top;
    }

    public boolean empty() {
        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
