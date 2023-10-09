import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int target = 8;
        int nums[] = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) return new int[]{-1,-1};

        int start = findStartPosition(nums, target, 0, nums.length);
        if(nums[start] != target) return new int[]{-1,-1};
        int end = findEndPosition(nums, target, start, nums.length);
        return new int[]{start, end};
    }

    public static int findStartPosition(int[] nums, int target, int left, int right){
        if(left >= right) {
            return left;
        }

        int middle = left + ((right - left) / 2);
        return (nums[middle] < target) ? findStartPosition(nums, target, middle + 1, right) : findStartPosition(nums, target, left, middle);
    }

    public static int findEndPosition(int[] nums, int target, int left, int right){
        if(left >= right) {
            return right - 1;
        }

        int middle = left + ((right - left) / 2);
        return (nums[middle] == target) ? findEndPosition(nums, target, middle + 1, right) : findEndPosition(nums, target, left, middle);
    }
}