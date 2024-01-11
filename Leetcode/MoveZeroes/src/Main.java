import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,0,3,0,13,0,0};
        moveZeroes(nums);
        System.out.println( Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[idx++] = nums[i];
            }
        }

        for(int i = idx; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}