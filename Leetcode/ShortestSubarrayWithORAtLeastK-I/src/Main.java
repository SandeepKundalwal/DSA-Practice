public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        int k = 2;
        System.out.println(minimumSubarrayLength(nums, k));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int mini = 51;
        for(int i = 0; i < n; i++){
            int or = 0;
            for(int j = i; j < n; j++){
                or |= nums[j];

                if(or >= k){
                    mini = Math.min(mini, j - i + 1);
                }
            }
        }
        return mini == 51 ? -1 : mini;
    }
}