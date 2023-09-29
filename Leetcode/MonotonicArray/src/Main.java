public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,4,5,5};
        System.out.println("isMonotonic: " + isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        if(nums.length <= 2){
            return true;
        }

        boolean isAscending = true, isDescending = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i]) isDescending = false;
            if(nums[i - 1] > nums[i]) isAscending = false;
        }
        return isAscending || isDescending;
    }
}