public class FirstIntuition {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + ((right - left) >> 1);

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // System.out.println(left);
        int start = 0;
        int end = nums.length - 1;
        if(target >= nums[left] && target <= nums[nums.length - 1]){
            start = left;
        } else {
            end = left;
        }

        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] == target){
                return mid;
            } else if(target > nums[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
