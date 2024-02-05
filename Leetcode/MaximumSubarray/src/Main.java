public class Main {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            sum += num;

            if(maxSum < sum){
                maxSum = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}