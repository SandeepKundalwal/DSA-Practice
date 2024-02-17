public class Main {
    public static void main(String[] args) {
        int nums[] = {3,2,6,1,4};
        System.out.println(maxOperations(nums));
    }

    public static int maxOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        int score = 0;
        for(int i = 0; i < n - 1; i += 2){
            if(score == 0){
                score = nums[i] + nums[i + 1];
                count++;
            } else {
                if(i + 1 < n && score == nums[i] + nums[i + 1]){
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}