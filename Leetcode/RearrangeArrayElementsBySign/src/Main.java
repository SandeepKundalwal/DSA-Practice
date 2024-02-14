import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        int pIdx = 0, nIdx = 1;
        for(int num : nums){
            if(num > 0){
                ans[pIdx] = num;
                pIdx += 2;
            } else {
                ans[nIdx] = num;
                nIdx +=2;
            }
        }

        return ans;
    }
}