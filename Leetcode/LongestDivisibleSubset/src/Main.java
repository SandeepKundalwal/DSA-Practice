import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int path[] = new int[n];
        Arrays.fill(path, -1);

        int DP[] = new int[n];
        Arrays.fill(DP, 1);

        int maxIdx = 0;
        for(int idx = 0; idx < n; idx++){
            for(int prevIdx = 0; prevIdx < idx; prevIdx++){
                if((nums[idx] % nums[prevIdx] == 0 || nums[prevIdx] % nums[idx] == 0) && 1 + DP[prevIdx] > DP[idx]){
                    DP[idx] = 1 + DP[prevIdx];
                    path[idx] = prevIdx;
                }
            }
            if(DP[maxIdx] < DP[idx]){
                maxIdx = idx;
            }
        }

        List<Integer> largestSubset = new ArrayList<>();
        while(maxIdx >= 0 ){
            largestSubset.add(nums[maxIdx]);
            maxIdx = path[maxIdx];
        }
        return largestSubset;
    }
}