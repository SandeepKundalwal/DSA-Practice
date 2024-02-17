import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {3,2,1,2,3,4};
        System.out.println(maxOperations(nums));
    }

    public static int maxOperations(int[] nums) {
        int n = nums.length;
        Map<String, Integer> MEMO = new HashMap<>();
        return f(0, n - 1, 0, nums, MEMO);
    }

    public static int f(int start, int end, int score, int nums[], Map<String, Integer> MEMO){
        if(start >= end){
            return 0;
        }

        String key = start + "|" + end + "|" + score;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        // pick first two elements
        int maxiF = 0;
        if(score == 0 || nums[start] + nums[start + 1] == score){
            maxiF = Math.max(maxiF, 1 + f(start + 2, end, nums[start] + nums[start + 1], nums,MEMO));
        }

        // pick first and last element
        int maxiFL = 0;
        if(score == 0 || nums[start] + nums[end] == score){
            maxiFL = Math.max(maxiFL, 1 + f(start + 1, end - 1, nums[start] + nums[end], nums, MEMO));
        }

        // pick last two elements
        int maxiL = 0;
        if(score == 0 || nums[end - 1] + nums[end] == score){
            maxiL = Math.max(maxiL, 1 + f(start, end - 2, nums[end - 1] + nums[end], nums, MEMO));
        }

        int ans = Math.max(maxiF, Math.max(maxiFL, maxiL));
        MEMO.put(key, ans);
        return ans;
    }
}