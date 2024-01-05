import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int MEMO[][] = new int[n][n + 1];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, MEMO);
    }

    private static int f(int idx, int prevIdx, int nums[], int MEMO[][]){
        if(idx >= nums.length){
            return 0;
        }

        int ans = MEMO[idx][prevIdx + 1];
        if(ans != -1){
            return ans;
        }

        int leave = 0 + f(idx + 1, prevIdx, nums, MEMO);

        int take = Integer.MIN_VALUE;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]){
            take = 1 + f(idx + 1, idx, nums, MEMO);
        }

        return MEMO[idx][prevIdx + 1] = Math.max(leave, take);
    }
}