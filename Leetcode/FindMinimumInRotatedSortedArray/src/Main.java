public class Main {
    public static void main(String[] args) {
        int nums[] = {2,3,4,5,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        int ans = 5001;
        while(left <= right){
            int mid = left + ((right - left) >> 1);

            ans = Math.min(ans, nums[mid]);

            if (nums[right] > nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}