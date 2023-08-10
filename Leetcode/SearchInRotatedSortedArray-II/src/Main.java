public class Main {
    public static void main(String[] args) {
        int target = 2;
        int nums[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println("Element Present: " + search(nums, target));
    }

    /**
     * find the pivot at which array is rotated -> not possible in O(logn)
     * find the target by moving in the particular space
     * Time Complexity: Average Case: O(logn); Worst Case: O(N)
     */
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(nums[mid] == target){
                return true;
            }  else if(nums[mid] == nums[left] && nums[mid] == nums[right]){
                left = left + 1;
                right = right - 1;
            } else if(nums[mid] <= nums[right]){
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }  else {
                    right = mid - 1;
                }
            } else {
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}