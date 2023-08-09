import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int p = 2;
        int nums[] = {10, 1, 2, 7, 1, 3};
        System.out.println("Ans: " + minimizeMax(nums, p));
    }

    public static int minimizeMax(int[] nums, int p) {
        if(p == 0){
            return 0;
        }

        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = nums[n - 1] - nums[0];

        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            int pairsCount = countPairs(nums, mid);

            if(pairsCount >= p){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int countPairs(int nums[], int threshold){
        int pairsCount = 0;

        for(int i = 1; i < nums.length; i++){
            // if a valid pair is found, we skip one element as it's previous element pair is already taken
            if(Math.abs(nums[i - 1] - nums[i]) <= threshold){
                i++;
                pairsCount++;
            }
        }

        return pairsCount;
    }
}