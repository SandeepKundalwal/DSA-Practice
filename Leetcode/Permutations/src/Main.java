import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        f(0, nums, allPermutations);
        return allPermutations;
    }

    public static void f(int idx, int nums[], List<List<Integer>> allPermutations){
        if(idx == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for(int num : nums){
                permutation.add(num);
            }
            allPermutations.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(i, idx, nums);
            f(idx + 1, nums, allPermutations);
            swap(i, idx, nums);
        }

    }

    public static void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}