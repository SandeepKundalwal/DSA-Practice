import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3,1,2};
        int k = 2;
        System.out.println(maxSubarrayLength(nums, k));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxi = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            int num = nums[right];
            if(map.containsKey(num)){
                if(map.get(num) < k){
                    map.put(num, map.get(num) + 1);
                    right++;
                } else {
                    while(left < right && nums[left] != num){
                        map.put(nums[left], map.get(nums[left]) - 1);
                        left++;
                    }
                    map.put(nums[left], map.get(nums[left]) - 1);
                    left++;
                }
            } else {
                map.put(num, 1);
                right++;
            }
            maxi = Math.max(maxi, right - left);
        }

        return maxi;
    }
}