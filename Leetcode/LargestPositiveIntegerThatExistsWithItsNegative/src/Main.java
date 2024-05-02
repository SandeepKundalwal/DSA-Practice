import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int nums[] = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(nums));
    }

    public static int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num < 0) {
                set.add(num);
            }
        }

        int largestK = -1;
        for(int num : nums){
            if(num > 0 && set.contains(-num)){
                largestK = Math.max(largestK, num);
            }
        }

        return largestK;
    }
}