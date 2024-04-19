import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int nums[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxi = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int count = 0;
                int element = num;
                while(set.contains(element)){
                    count++;
                    element++;
                }

                maxi = Math.max(maxi, count);
            }
        }

        return maxi;
    }
}