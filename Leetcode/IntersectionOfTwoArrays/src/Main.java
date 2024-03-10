import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean nums[] = new boolean[1001];
        for(int i = 0; i < nums1.length; i++){
            nums[nums1[i]] = true;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(nums[nums2[i]]){
                set.add(nums2[i]);
            }
        }

        int idx = 0;
        int ans[] = new int[set.size()];
        for(int num : set){
            ans[idx++] = num;
        }
        return ans;
    }
}