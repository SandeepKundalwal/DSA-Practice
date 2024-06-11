import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {18, 12, 10, 5, 6, 2, 18, 3};
        int k = 8;
        System.out.println(beautifulSubsets(nums, k));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        return f(0, 0, nums, k);
    }

    public static int f(int i, int mask, int nums[], int k){
        if(i >= nums.length){
            return mask == 0 ? 0 : 1;
        }

        boolean isNotSafe = false;
        for(int j = 0; j < i && !isNotSafe; j++){
            if((mask & (1 << j)) != 0){
                isNotSafe = Math.abs(nums[j] - nums[i]) == k;
            }
        }

        int leave = f(i + 1, mask, nums, k);

        int take = 0;
        if(!isNotSafe){
            take = f(i + 1, (mask | (1 << i)), nums, k);
        }

        return leave + take;
    }
}