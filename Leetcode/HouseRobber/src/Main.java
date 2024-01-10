import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int MEMO[] = new int[nums.length];
        Arrays.fill(MEMO, -1);
        return f(0, nums, MEMO);
    }

    public static int f(int idx, int nums[], int MEMO[]){
        if(idx >= nums.length){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        int leaveHouse = 0 + f(idx + 1, nums, MEMO);
        int robHouse = nums[idx] + f(idx + 2, nums, MEMO);

        return MEMO[idx] = Math.max(leaveHouse, robHouse);
    }
}