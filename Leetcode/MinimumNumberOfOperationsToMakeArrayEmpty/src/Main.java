import java.util.Arrays;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,1,2,2,4,3,3,4,2,4};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);

        int MEMO[] = new int[nums.length];
        Arrays.fill(MEMO, -1);
        int minOperations = f(0, nums, MEMO);
        return minOperations == (int) 1e7 ? -1 : minOperations;
    }

    private static int f(int idx, int nums[], int MEMO[]){
        if(idx >= nums.length){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        int removeTwo = (int) 1e7;

        if(idx + 1 < nums.length && nums[idx] == nums[idx + 1]){
            removeTwo = Math.min(removeTwo, 1 + f(idx + 2, nums, MEMO));
        }

        int removeThree = (int) 1e7;
        if(idx + 1 < nums.length && idx + 2 < nums.length && nums[idx] == nums[idx + 1] && nums[idx] == nums[idx + 2]){
            removeTwo = Math.min(removeTwo, 1 + f(idx + 3, nums, MEMO));
        }

        return MEMO[idx] = Math.min(removeTwo, removeThree);
    }
}