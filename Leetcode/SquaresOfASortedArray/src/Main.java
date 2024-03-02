public class Main {
    public static void main(String[] args) {
        int nums[] = {-4,-1,0,3,10};
        System.out.println(sortedSquares(nums));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int sqrdNums[] = new int[n];

        int idx = n - 1;
        int left = 0, right = n - 1;
        while(left <= right){
            int start = nums[left] * nums[left];
            int end = nums[right] * nums[right];

            if(start <= end){
                sqrdNums[idx--] = end;
                right--;
            } else {
                sqrdNums[idx--] = start;
                left++;
            }
        }

        return sqrdNums;
    }
}