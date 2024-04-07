import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 5, 6, 8, 5};
        int k = 4;
        System.out.println(minOperationsToMakeMedianK(nums, k));
    }

    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        long ans = 0;
        int midIdx = n / 2;

        if (nums[midIdx] == k) return 0;

        if (nums[midIdx] > k) {
            while (midIdx >= 0 && nums[midIdx] > k) {
                ans += (nums[midIdx] - k);
                midIdx--;
            }
        } else {
            while (midIdx < n && nums[midIdx] < k) {
                ans += (k - nums[midIdx]);
                midIdx++;
            }
        }

        return ans;
    }
}