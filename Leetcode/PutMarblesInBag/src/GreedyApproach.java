import java.util.Arrays;

public class GreedyApproach {
    /**
     Greedy Approach.
     Time Complexity: O(nlogn)
     Space Complexity: O(n)
     */
    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairs = new int[n - 1];

        for(int i = 0; i < n - 1; i++){
            pairs[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairs, 0, n - 1);

        long answer = 0;
        for(int i = 0; i < k - 1; i++){
            answer += pairs[n - 2 - i] - pairs[i];
        }
        return answer;
    }
}
