import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int k = 3;
        int[] weights = {1,4,2,5,2};
        System.out.println("Recursive Approach: " + RecursiveApproach.putMarbles(weights, k));
        System.out.println("Greedy Approach: " + GreedyApproach.putMarbles(weights, k));
    }


}