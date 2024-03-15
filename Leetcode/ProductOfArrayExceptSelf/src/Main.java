import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            ans[i] = nums[i] * ans[i + 1];
        }

        int prefix = 1;
        for(int i = 0; i < n; i++){
            if(i == 0){
                ans[i] = ans[i + 1];
            } else if (i == n - 1){
                ans[i] = prefix;
            } else {
                ans[i] = prefix * ans[i + 1];
            }
            prefix *= nums[i];
        }

        return ans;
    }
}