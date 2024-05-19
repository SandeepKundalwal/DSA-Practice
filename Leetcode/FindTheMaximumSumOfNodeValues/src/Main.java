import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {9,70,77,2,24,15,2,47,46,15};
        int k = 159;
        int edges[][] = {
                {0,6},{0,5},{0,1},{6,8},{8,3},{8,4},{1,7},{5,9},{0,2}
        };
        System.out.println(maximumValueSum(nums, k, edges));
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;

        long totalSum = 0;
        int deltas[] = new int[n];
        for(int i = 0; i < n; i++){
            deltas[i] = (nums[i] ^ k) - nums[i];
            totalSum += nums[i];
        }

        Arrays.sort(deltas);

        for(int i = n - 2; i >= 0; i -= 2){
            long pairSum = deltas[i] + deltas[i + 1];
            if(pairSum > 0){
                totalSum += pairSum;
            } else {
                break;
            }
        }

        return totalSum;
    }
}