import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int prefix = 0;
        map.put(prefix, 1);
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            int need = prefix - goal;
            if(map.containsKey(need)){
                count += map.get(need);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}