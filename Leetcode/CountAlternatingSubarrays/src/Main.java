public class Main {
    public static void main(String[] args) {
        int nums[] = {0,1,1,1};
        System.out.println(countAlternatingSubarrays(nums));
    }

    public static long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;

        int left = 0, right = 0;
        while(right < n){
            if(left != right && nums[right - 1] == nums[right]){
                left = right;
            }
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}