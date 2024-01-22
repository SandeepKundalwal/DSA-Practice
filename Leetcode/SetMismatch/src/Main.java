import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n + 1];

        for(int num : nums){
            freq[num]++;
        }

        int ans[] = new int[2];
        for(int i = 1; i <= n; i++){
            if(freq[i] > 1){
                ans[0] = i;
            } else if(freq[i] == 0){
                ans[1] = i;
            }
        }
        return ans;
    }
}