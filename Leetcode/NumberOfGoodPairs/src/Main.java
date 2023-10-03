public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1,1,3};
        System.out.println("Number of Good Pairs: " + numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}