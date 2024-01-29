import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {7,7,7,7,7};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        /*
          Map-> key:difference ; value: no of chains
        */
        int n = nums.length;
        Map<Long, Integer> DP[] = new HashMap[n];
        for(int i = 0; i < n; i++){
            DP[i] = new HashMap<>();
        }

        int count = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                long difference = (long)nums[i] - nums[j];

                DP[i].put(difference, DP[i].getOrDefault(difference, 0) + 1);
                if(DP[j].containsKey(difference)){
                    count += DP[j].get(difference);
                    DP[i].put(difference, DP[i].get(difference) + DP[j].get(difference));
                }
            }
        }
        return count;
    }
}