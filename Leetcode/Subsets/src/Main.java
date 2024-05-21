import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();

        for(int i = 0; i < (1 << n); i++){
            List<Integer> subset = new ArrayList<>();
            for(int k = 0; k < n; k++){
                if((i & (1 << k)) != 0){
                    subset.add(nums[k]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }
}