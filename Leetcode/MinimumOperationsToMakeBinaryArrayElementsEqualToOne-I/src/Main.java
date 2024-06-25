public class Main {
    public static void main(String[] args) {
        int nums[] = {0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;

        int steps = 0;
        for(int i = 0; i < n - 2; i++){
            if(nums[i] == 0){
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                steps++;
            }
        }


        return nums[n - 1] == 0 || nums[n - 2] == 0 ? -1 : steps;
    }
}