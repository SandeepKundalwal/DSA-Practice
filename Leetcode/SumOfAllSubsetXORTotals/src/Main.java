public class Main {
    public static void main(String[] args) {
        int nums[] = {3,4,5,6,7,8};
        System.out.println(subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        int n = nums.length;

        int xorSum = 0;
        for(int subset = 0; subset < (1 << n); subset++){
            int currSubsetSum = 0;
            for(int bit = 0; bit < n; bit++){
                if((subset & (1 << bit)) != 0){
                    currSubsetSum ^= nums[bit];
                }
            }
            xorSum += currSubsetSum;
        }

        return xorSum;
    }
}