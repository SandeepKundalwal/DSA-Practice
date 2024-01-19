import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5,6};
        int nums2[] = {2,3,2,3,2,3};
        System.out.println(maximumSetSize(nums1, nums2));
    }

    public static int maximumSetSize(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int r1 = n1 / 2, r2 = n2 / 2;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < n1; i++){
            if(!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            } else {
                r1--;
            }

            if(!set2.contains(nums2[i])){
                set2.add(nums2[i]);
            } else {
                r2--;
            }
        }

        for(int num : nums1){
            if(r1 <= 0) break;
            if(set1.contains(num) && set2.contains(num)){
                r1--;
                set1.remove(num);
            }
        }

        for(int num : nums2){
            if(r2 <= 0) break;
            if(set2.contains(num) && set1.contains(num)){
                r2--;
                set2.remove(num);
            }
        }

        if(r1 > 0){
            for(int num : nums1){
                if(r1 <= 0) break;
                if(set1.contains(num)){
                    r1--;
                    set1.remove(num);
                }
            }
        }

        if(r2 > 0){
            for(int num : nums2){
                if(r2 <= 0) break;
                if(set2.contains(num)){
                    r2--;
                    set2.remove(num);
                }
            }
        }

        Set<Integer> ans = new HashSet<>();
        ans.addAll(set1);
        ans.addAll(set2);

        return ans.size();
    }
}