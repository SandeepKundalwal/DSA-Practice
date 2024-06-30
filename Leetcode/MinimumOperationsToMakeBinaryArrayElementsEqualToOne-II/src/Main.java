public class Main {
    public static void main(String[] args) {
        int nums[] = {0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;

        int flip = 0;
        for(int i = 0; i < n; i++){
            if((nums[i] == 0 && flip % 2 == 1) || (nums[i] == 1 && flip % 2 == 0)) continue;

            flip++;
        }

        return flip;
    }
}