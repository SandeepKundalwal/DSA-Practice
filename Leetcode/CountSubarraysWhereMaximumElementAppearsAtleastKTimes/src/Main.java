public class Main {
    public static void main(String[] args) {
        int k = 2;
        int nums[] = {1,3,2,2,2,2,2,2,3,3};
        System.out.println(countSubarrays(nums, k));
    }

    /*
        Sliding Window Strategy surely.
    */
    public static long countSubarrays(int[] nums, int k) {
        int max = maxElement(nums);
        // System.out.println(max);

        int left = 0, right = 0;
        long count = 0;
        int occurence = 0;
        while(right < nums.length){
            if(max == nums[right]){
                occurence++;
            }

            if(occurence >= k){
                count += (nums.length - right);

                while(left < right && nums[left] != max){
                    count += (nums.length - right);
                    left++;
                }
                left++;
                occurence--;
            }
            right++;
        }
        return count;
    }

    public static int maxElement(int nums[]){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        return max;
    }
}