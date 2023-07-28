public class Main {
    public static void main(String[] args) {
        int nums[] = {1, 5, 233, 7};
        System.out.println("Player A can win? " + (PredictTheWinner(nums) ? "Yes" : "No"));
    }

    public static boolean PredictTheWinner(int[] nums) {
        return f(0, 0, 0, nums.length - 1, 1, nums);
    }

    public static boolean f(int scoreOne, int scoreTwo, int left, int right, int turn, int nums[]){
        if(left > right){
            return scoreOne >= scoreTwo;
        }

        if(turn == 1){
            return f(scoreOne + nums[left], scoreTwo, left + 1, right, 2, nums)
                    || f(scoreOne + nums[right], scoreTwo, left, right - 1, 2, nums);
        }

        return f(scoreOne, scoreTwo + nums[left], left + 1, right, 1, nums)
                && f(scoreOne, scoreTwo + nums[right], left, right - 1, 1, nums);
    }
}