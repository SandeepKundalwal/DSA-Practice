import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 10;
        int nums[] = {2,11,10,1,3};
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= k) return i;
        }
        return -1;
    }
}