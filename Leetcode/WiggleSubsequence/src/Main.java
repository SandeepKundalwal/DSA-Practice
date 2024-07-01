import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLengthON2(nums));
    }

    public static int wiggleMaxLengthON2(int[] nums) {
        int n = nums.length;

        int MEMO[][] = new int[n][n + 1];
        for(int oneD[] : MEMO){
            Arrays.fill(oneD, -1);
        }

        return f(0, -1, nums, MEMO);
    }

    public static int f(int idx, int prevIdx, int nums[], int MEMO[][]){
        if(idx >= nums.length){
            return 0;
        }

        if(MEMO[idx][prevIdx + 1] != -1){
            return MEMO[idx][prevIdx + 1];
        }

        int leave = 0 + f(idx + 1, prevIdx, nums, MEMO);

        int take = 0;
        if(prevIdx == -1 ||
                (nums[idx] - nums[prevIdx] > 0 && (idx == nums.length - 1 || nums[idx + 1] - nums[idx] < 0)) ||
                (nums[idx] - nums[prevIdx] < 0 && (idx == nums.length - 1 || nums[idx + 1] - nums[idx] > 0))
        ){
            take = 1 + f(idx + 1, idx, nums, MEMO);
        }

        return MEMO[idx][prevIdx + 1] = Math.max(leave, take);
    }
}