import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i]) && Math.abs(i - hashMap.get(nums[i])) <= k){
                return true;
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return false;
    }
}