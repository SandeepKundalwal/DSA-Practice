public class Main {
    public static void main(String[] args) {
        System.out.println(countMatchingSubarrays(new int[]{1,4,4,1,3,5,5,3}, new int[]{1,0,-1}));
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;

        int n = nums.length;
        int p = pattern.length;

        for(int i = 0; i < n - p; i++){
            boolean patternFound = true;
            for(int k = 0; k < p; k++){
                if(pattern[k] == 1){
                    if(nums[i + k + 1] <= nums[i + k]){
                        patternFound = false;
                    }
                } else if(pattern[k] == 0){
                    if(nums[i + k + 1] < nums[i + k] || nums[i + k + 1] > nums[i + k]){
                        patternFound = false;
                    }
                } else {
                    if(nums[i + k + 1] >= nums[i + k]){
                        patternFound = false;
                    }
                }

                if(!patternFound){
                    break;
                }
            }
            if(patternFound){
                count++;
            }
        }
        return count;
    }
}