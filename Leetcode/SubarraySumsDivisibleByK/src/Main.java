import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int modPrefix = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            modPrefix = (modPrefix + nums[i] % k + k) % k;
            if(hashMap.containsKey(modPrefix)){
                count += hashMap.get(modPrefix);
            }
            hashMap.put(modPrefix, hashMap.getOrDefault(modPrefix, 0) + 1);
        }

        return count;
    }
}