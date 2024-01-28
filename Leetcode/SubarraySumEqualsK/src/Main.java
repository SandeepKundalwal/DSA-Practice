import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int nums[] = {1,1,1};
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            int remove = prefix - k;
            if(hashMap.containsKey(remove)){
                count += hashMap.get(remove);
            }
            hashMap.put(prefix, hashMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}