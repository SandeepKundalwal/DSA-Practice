public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        long newNums[] = new long[nums.length + 2];
        newNums[0] = newNums[newNums.length - 1] = Long.MIN_VALUE;
        for(int i = 1; i < nums.length + 1; i++){
            newNums[i] = nums[i - 1];
        }
        return binarySearch(newNums);
    }

    public static int binarySearch(long nums[]){
        int left = 1, right = nums.length - 2;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            /*
                1. If in sorted order at mid, move left = mid + 1
                2. If mid is peak, return;
                3. If mid + 1 is less than mid and mid - 1 is greater,  move right = mid - 1;
            */
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid - 1;
            } else if(nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}