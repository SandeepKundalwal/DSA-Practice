import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,3,2,3,3,3};
        System.out.println("Using HashMap: " + majorityElementUsingHashMap(nums));
        System.out.println("Using NestedLoop: " + majorityElementUsingNestedLoop(nums));
    }

    public static List<Integer> majorityElementUsingNestedLoop(int[] nums) {
        int threshold = (int)nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int cnt = 1;
            if(nums[i] == Integer.MAX_VALUE) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == nums[i]){
                    cnt++;
                    nums[j] = Integer.MAX_VALUE;
                }
            }

            if(cnt > threshold){
                result.add(nums[i]);
            }
        }

        return result;
    }

    public static List<Integer> majorityElementUsingHashMap(int[] nums) {
        int threshold = (int)nums.length / 3;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int num : nums){
            if(!hashMap.containsKey(num)){
                hashMap.put(num, 0);
            }
            hashMap.put(num, hashMap.get(num) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> it : hashMap.entrySet()){
            if(it.getValue() > threshold){
                result.add(it.getKey());
            }
        }

        return result;
    }

}