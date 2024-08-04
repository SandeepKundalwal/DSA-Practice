import java.util.Arrays;

public class Main {
    static final int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int noOfSubarrays = (n * (n + 1)) / 2;
        int subarraySums[] = new int[noOfSubarrays];

        int idx = 0;
        for(int i = 0; i < n; i++){
            int runningSum = 0;
            for(int j = i; j < n; j++){
                runningSum += nums[j];
                subarraySums[idx++] = runningSum;
            }
        }

        Arrays.sort(subarraySums);

        int ans = 0;
        for(int i = left - 1; i < right; i++){
            ans = (ans + subarraySums[i]) % MOD;
        }

        return ans;
    }
}