import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,3,1,6};
        int queries[][] = {{0,2},{2,3}};
        System.out.println(Arrays.toString(isArraySpecial(nums, queries)));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int prefix[] = new int[n];
        for(int i = 1; i < n; i++){
            if(nums[i - 1] % 2 == nums[i] % 2){
                prefix[i] = 1 + prefix[i - 1];
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        boolean answer[] = new boolean[q];
        for(int i = 0; i < q; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            answer[i] = (prefix[end] == prefix[start]);
        }

        return answer;
    }
}