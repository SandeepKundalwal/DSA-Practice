public class Main {
    public static void main(String[] args) {
        int nums[] = {4,3,1,6};
        System.out.println(isArraySpecial(nums));
    }

    public static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i - 1] % 2 == nums[i] % 2){
                return false;
            }
        }

        return true;
    }
}