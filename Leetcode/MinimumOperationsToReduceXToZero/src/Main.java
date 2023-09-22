public class Main {
    public static void main(String[] args) {
        int x = 5;
        int nums[] = {1,1,4,2,3};
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int target = sum - x;
        int left = 0, currentSum = 0, maxLength = -1;
        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];
            while(left <= right && currentSum > target){
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == target){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}