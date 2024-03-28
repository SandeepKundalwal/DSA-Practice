public class Main {
    public static void main(String[] args) {
        int nums[] = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;

        int count = 0;
        int left = 0, right = 0;

        int product = 1;
        while(right < n){
            product *= nums[right];

            if(product >= k){
                while(left <= right && product >= k){
                    product /= nums[left++];
                }
            }
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}