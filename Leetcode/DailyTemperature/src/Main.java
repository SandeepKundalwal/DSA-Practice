import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int temperatures[] = {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    // Most probably monotonic stack
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<TemperatureIndex> stack = new Stack<>();
        stack.push(new TemperatureIndex(n - 1, temperatures[n - 1]));

        int result[] = new int[n];
        for(int i = n - 2; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= stack.peek().temperature){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek().index - i;
            stack.push(new TemperatureIndex(i, temperatures[i]));
        }
        return result;
    }

    public static class TemperatureIndex{
        int index;
        int temperature;

        public TemperatureIndex(int index, int temperature){
            this.index = index;
            this.temperature = temperature;
        }
    }
}