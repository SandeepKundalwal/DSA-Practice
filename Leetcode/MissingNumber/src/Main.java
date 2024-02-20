public class Main {
    public static void main(String[] args) {
        int nums[] = {0,4,2,3,5};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;

        long totalSum = ((long) n * (n + 1)) / 2;

        for(int num : nums){
            totalSum -= num;
        }

        return (int) totalSum;
    }
}