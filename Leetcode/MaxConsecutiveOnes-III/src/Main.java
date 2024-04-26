public class Main {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int maxi = 0;
        int left = 0, right = 0;
        while(right < n){
            if(nums[right] == 0){
                if(k > 0){
                    k--;
                } else {
                    maxi = Math.max(maxi, right - left);

                    while(left <= right && k <= 0){
                        if(nums[left] == 0) {
                            k++;
                        }
                        left++;
                    }
                    right--;
                }
            }
            right++;
        }

        return Math.max(maxi, right - left);
    }
}