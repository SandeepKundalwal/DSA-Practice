import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int num = nums[i];
            if(num != -1 && nums[num - 1] != -1){
                nums[i] = nums[num - 1];
                nums[num - 1] = -1;
            } else {
                i++;
            }
        }

        List<Integer> duplicates = new ArrayList<>();

        for(int num : nums){
            if(num != -1){
                duplicates.add(num);
            }
        }

        return duplicates;
    }
}