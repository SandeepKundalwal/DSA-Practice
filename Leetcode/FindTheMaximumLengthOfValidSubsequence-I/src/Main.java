public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,1,1,2,1,2};
        System.out.println(maximumLength(nums));
    }

    /*
    1. Only 4 sequences possible: even-even, even-odd, odd-odd, odd-even
    2. Convert the nums in binary
    3. Solved in first attempt.
    4. Time Complexity: O(n)
    */
    public static int maximumLength(int[] nums) {
        int n = nums.length;

        int evenEven = 0, oddOdd = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
                evenEven++;
            } else {
                nums[i] = 1;
                oddOdd++;
            }
        }

        int evenOdd = f(nums, 0);
        int oddEven = f(nums, 1);

        return Math.max(evenOdd, Math.max(oddEven, Math.max(evenEven, oddOdd)));
    }

    public static int f(int nums[], int turn){
        int n = nums.length;

        int count = 0;
        for(int i = 0; i < n; i++){
            if((turn == 0 && nums[i] == 0) || turn == 1 && nums[i] == 1){
                count++;
                turn ^= 1;
            }
        }

        return count;
    }
}