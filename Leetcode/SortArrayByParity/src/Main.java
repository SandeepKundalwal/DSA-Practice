import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,4,3,2};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        int start = 0, end = n - 1;

        for(int num : nums){
            if(num % 2 == 0){
                res[start++] = num;
            } else {
                res[end--] = num;
            }
        }
        return res;
    }
}