import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            prefixMod = (prefixMod + nums[i]) % k;
            if(map.containsKey(prefixMod)){
                if(i - map.get(prefixMod) >= 2){
                    return true;
                } else {
                    continue;
                }
            }
            map.put(prefixMod, i);
        }

        return false;
    }
}