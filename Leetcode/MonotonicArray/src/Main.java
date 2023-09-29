public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,4,5,5};
        System.out.println("isMonotonic Ascending/Descending: " + isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean isMonotonic = true;
        // Ascending Monotonic;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] > nums[i]){
                isMonotonic = false;
            }
        }

        if(isMonotonic){
            return true;
        }

        isMonotonic = true;
        // Descending Monotonic
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i]){
                isMonotonic = false;
            }
        }

        return isMonotonic;
    }
}