public class Main {
    public static void main(String[] args) {
        int nums[] = {1,4,3,3,2};
        System.out.println(longestMonotonicSubarray(nums));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int maxi = 0;

        for(int i = 0; i < nums.length; i++){
            int iL = 0;
            for(int j = i; j < nums.length - 1; j++){
                if(nums[j] < nums[j + 1]){
                    iL++;
                } else {
                    break;
                }
            }

            int dL = 0;
            for(int j = i; j < nums.length - 1; j++){
                if(nums[j] > nums[j + 1]){
                    dL++;
                } else {
                    break;
                }
            }

            maxi = Math.max(maxi, Math.max(iL, dL) + 1);
        }

        return maxi;
    }
}