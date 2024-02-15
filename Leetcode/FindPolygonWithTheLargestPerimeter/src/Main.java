import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,12,1,2,5,50,3};
        System.out.println(largestPerimeter(nums));
    }

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long prefixSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum += nums[i];
        }

        for(int i = nums.length - 1; i >= 2; i--){
            if(prefixSum - nums[i] > nums[i]){
                return prefixSum;
            }
            prefixSum -= nums[i];
        }

        return -1;
    }
}