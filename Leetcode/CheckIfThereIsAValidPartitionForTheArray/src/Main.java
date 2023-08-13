import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,4,4,5,6};
        System.out.println("Is Possible: " + validPartition(nums));
    }

    public static boolean validPartition(int[] nums) {
        Map<Integer, Boolean> MEMO = new HashMap<>();
        return f(0, nums, MEMO);
    }

    public static boolean f(int idx , int nums[], Map<Integer, Boolean> MEMO){
        if(idx >= nums.length){
            return true;
        }

        if(MEMO.containsKey(idx)){
            return MEMO.get(idx);
        }

        boolean ans = false;
        if((idx + 1 < nums.length) && (nums[idx] == nums[idx + 1])){
            ans = ans || f(idx + 2, nums, MEMO);
        }

        if((idx + 2 < nums.length) && (nums[idx] == nums[idx + 1]) && (nums[idx + 1] == nums[idx + 2])){
            ans = ans || f(idx + 3, nums, MEMO);
        }

        if((idx + 2 < nums.length) && (nums[idx + 1] - nums[idx] == 1) && ((nums[idx + 2] - nums[idx + 1] == 1))){
            ans = ans || f(idx + 3, nums, MEMO);
        }

        MEMO.put(idx, ans);
        return ans;
    }
}