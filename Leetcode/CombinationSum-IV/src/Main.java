import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int target = 4;
        int nums[] = {1, 2, 3};
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int MEMO[] = new int[1001];
        Arrays.fill(MEMO, -1);

        return f(0, target, nums, MEMO);
    }

    public static int f(int sum, int target, int nums[], int MEMO[]) {
        if (sum == target) {
            return 1;
        }

        if (MEMO[sum] != -1) {
            return MEMO[sum];
        }

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) continue;
            cnt += f(sum + nums[i], target, nums, MEMO);
        }

        return MEMO[sum] = cnt;
    }
}