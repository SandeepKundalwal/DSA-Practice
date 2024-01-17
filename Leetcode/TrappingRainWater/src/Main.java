import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int answers[] = {6,9,2,1};
        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        testcases.add(new int[]{4,2,0,3,2,5});
        testcases.add(new int[]{2,0,2});
        testcases.add(new int[]{5,4,1,2});

        FirstIntuition firstIntuition = new FirstIntuition();
        for(int i = 0; i < testcases.size(); i++){
            System.out.println(answers[i] + " == " + firstIntuition.trap(testcases.get(i)));
        }

        BetterSolution betterSolution = new BetterSolution();
        for(int i = 0; i < testcases.size(); i++){
            System.out.println(answers[i] + " == " + betterSolution.trap(testcases.get(i)));
        }
    }
}