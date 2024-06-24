import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }

    public static int f(int nums[], int k){
        int n = nums.length;

        int count = 0;
        int countOdd = 0;
        int left = 0, right = 0;
        while(right < n){
            countOdd += (nums[right] % 2);
            while(left <= right && countOdd > k){
                countOdd -= (nums[left] % 2);
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    /*
    Using HashMap O(N) space
     */
    public static int numberOfSubarraysUsingMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int countOdd = 0;
        int niceSubArrays = 0;
        for(int num : nums){
            countOdd += (num % 2);
            int need = countOdd - k;
            if(map.containsKey(need)){
                niceSubArrays += map.get(need);
            }
            map.put(countOdd, map.getOrDefault(countOdd, 0) + 1);
        }

        return niceSubArrays;
    }
}