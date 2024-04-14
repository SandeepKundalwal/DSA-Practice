import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,2,9,5,3};
        System.out.println(maximumPrimeDifference(nums));
    }

    public static int maximumPrimeDifference(int[] nums) {
        List<Integer> indexes = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 1) continue;

            boolean prime = true;
            for(int j = 2; j * j <= nums[i]; j++){
                if(nums[i] % j == 0){
                    prime = false;
                    break;
                }
            }

            if(prime){
                indexes.add(i);
            }
        }

        Collections.sort(indexes);

        return Math.abs(indexes.get(0) - indexes.get(indexes.size() - 1));
    }
}