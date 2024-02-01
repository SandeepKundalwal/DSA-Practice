import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int nums[] = {1,3,4,8,7,9,3,5,1};
        System.out.println(Arrays.deepToString(divideArray(nums, k)));
    }

    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int idx = -1;
        int n = nums.length;
        int result[][] = new int[n / 3][3];
        for(int i = 0; i < n; i++){
            if(i % 3 == 0){
                idx++;
                result[idx][0] = nums[i];
                continue;
            }

            if(nums[i] - result[idx][0] <= k){
                result[idx][i % 3] = nums[i];
            } else {
                return new int[0][];
            }
        }
        return result;
    }
}