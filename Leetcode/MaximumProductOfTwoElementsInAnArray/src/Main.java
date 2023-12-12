public class Main {
    public static void main(String[] args) {
        int nums[] = {3,4,5,2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int largest = nums[0];
        int secondLargest = nums[1];

        if(secondLargest > largest){
            largest = nums[1];
            secondLargest = nums[0];
        }

        for(int i = 2; i < nums.length; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest){
                secondLargest = nums[i];
            }
        }

        return (secondLargest - 1) * (largest - 1);
    }
}