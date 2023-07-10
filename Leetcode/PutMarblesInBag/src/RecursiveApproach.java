import java.util.ArrayList;
import java.util.List;

public class RecursiveApproach {
    /**
     * Let's first focus on dividing the array into K subarrays
     * Once the arrays are divided into K subarrays, will move to find whats asked
     * Time Complexity: O(nCk)
     */

    static int minScore = Integer.MAX_VALUE;
    static int maxScore = Integer.MIN_VALUE;
    public static long putMarbles(int[] weights, int k) {
        backtrack(weights, k, 0, new ArrayList<>());
        return maxScore - minScore;
    }

    private static void backtrack(int[] weights, int k, int start, List<List<Integer>> currentCombination) {
        if (start == weights.length && k == 0) {
            int subArraySum = 0;
            for(List<Integer> individualDistribution : currentCombination){
                subArraySum += individualDistribution.get(0) + individualDistribution.get(individualDistribution.size() - 1);
            }
            minScore = Math.min(minScore, subArraySum);
            maxScore = Math.max(maxScore, subArraySum);
            return;
        }

        if (start >= weights.length || k <= 0) {
            return;
        }

        for (int end = start; end < weights.length; end++) {
            currentCombination.add(getSubArray(weights, start, end));
            backtrack(weights, k - 1, end + 1, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    private static List<Integer> getSubArray(int[] weights, int start, int end) {
        List<Integer> subArray = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            subArray.add(weights[i]);
        }
        return subArray;
    }
}

