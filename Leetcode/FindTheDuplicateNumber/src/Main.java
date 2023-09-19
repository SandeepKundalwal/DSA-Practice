import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 2, 2};
        System.out.println("HashSet: " + findDuplicateUsingHashSet(nums));
        System.out.println("Floyd's Cycle Detection: " + findDuplicate(nums));
    }

    /**
     * Floyd's Cycle Detection
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }  while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static int findDuplicateUsingHashSet(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for(int num : nums){
            if(hashSet.contains(num)){
                return num;
            }
            hashSet.add(num);
        }
        return -1;
    }
}