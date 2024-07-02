import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int freq1[] = new int[1001];
        for(int num : nums1){
            freq1[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for(int num : nums2){
            if(freq1[num] > 0){
                result.add(num);
                freq1[num]--;
            }
        }

        return result.stream().mapToInt(e -> e).toArray();
    }
}