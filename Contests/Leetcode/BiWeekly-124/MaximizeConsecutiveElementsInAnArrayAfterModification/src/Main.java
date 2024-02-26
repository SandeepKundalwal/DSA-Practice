import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2,1,5,1,1};
        System.out.println("Memoization: " + maxSelectedElementsMemoization(nums));
        System.out.println("DP: " + maxSelectedElementsLIS(nums));
    }

    public static int maxSelectedElementsLIS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxi = 0;
        int DP[] = new int[nums[n - 1] + 2];
        for(int num : nums){
            DP[num + 1] = DP[num] + 1;
            DP[num] = DP[num - 1] + 1;
            maxi = Math.max(maxi, Math.max(DP[num], DP[num + 1]));
        }

        return maxi;
    }


    // TLE: passed 661/668 test cases
    public static int maxSelectedElementsMemoization(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return fMEMO(0, -1, nums, memo);
    }

    public static int fMEMO(int idx, int prev, int nums[], Map<Integer, Map<Integer, Integer>> memo){
        if(idx >= nums.length){
            return 0;
        }

        if(memo.containsKey(idx) && memo.get(idx).containsKey(prev)){
            return memo.get(idx).get(prev);
        }

        int leave = 0 + fMEMO(idx + 1, prev, nums, memo);

        int take = 0;
        if(prev == -1){
            take = Math.max(take, 1 + fMEMO(idx + 1, nums[idx], nums, memo));
            take = Math.max(take, 1 + fMEMO(idx + 1, nums[idx] + 1, nums, memo));
        } else if(nums[idx] - prev == 1){
            take = Math.max(take, 1 + fMEMO(idx + 1, nums[idx], nums, memo));
        } else if((nums[idx] + 1) - prev == 1){
            take = Math.max(take, 1 + fMEMO(idx + 1, nums[idx] + 1, nums, memo));
        }

        int ans = Math.max(take, leave);
        memo.computeIfAbsent(idx, k -> new HashMap<>()).put(prev, ans);
        return ans;
    }
}