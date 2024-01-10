import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int MEMO[] = new int[nums.length];
        Arrays.fill(MEMO, -1);
        return f(0, nums, MEMO);
    }

    public static int f(int idx, int nums[], int MEMO[]){
        if(idx == nums.length - 1){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        int cnt = (int) 1e6;
        for(int i = 1; i <= nums[idx]; i++){
            if(idx + i < nums.length){
                cnt = Math.min(cnt, 1 + f(idx + i, nums, MEMO));
            }
        }

        return MEMO[idx] = cnt;
    }
}