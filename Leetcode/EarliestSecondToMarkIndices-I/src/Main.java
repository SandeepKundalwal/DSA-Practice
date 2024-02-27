import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2,2,0};
        int changeIndices[] = {2,2,2,2,3,2,2,1};
        System.out.println(earliestSecondToMarkIndices(nums, changeIndices));
    }

    public static int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;

        for(int i = 0; i < m; i++){
            changeIndices[i]--;
        }

        int s = m + 1;
        int left = 0, right = m - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(isPossible(mid, nums, changeIndices) == 0){
                s = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return s == m + 1 ? -1 : s + 1;
    }

    public static int isPossible(int mid, int nums[], int changeIndices[]){
        int n = nums.length;
        int m = changeIndices.length;

        int iP[] = new int[n];
        Arrays.fill(iP, -1);

        int coversAllIndices = 0;
        for(int i = mid; i >= 0 ; i--){
            int idx = changeIndices[i];
            if(iP[idx] == -1){
                iP[idx] = i;
                coversAllIndices++;
            }
        }

        if(coversAllIndices != n) return -1;

        int power = 0;
        for(int i = 0; i <= mid; i++){
            int idx = changeIndices[i];
            if(iP[idx] == i){
                if(power >= nums[idx]){
                    power -= nums[idx];
                } else {
                    return -1;
                }
            } else {
                power++;
            }
        }

        return 0;
    }
}