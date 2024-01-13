import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;

        int idx = -1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            reverseArray(0, n - 1, nums);
            return;
        }

        for(int i = n - 1; i > idx; i--){
            if(nums[idx] < nums[i]){
                swap(idx, i, nums);
                break;
            }
        }

        reverseArray(idx + 1, n - 1, nums);
    }

    public static void reverseArray(int start, int end, int nums[]){
        while(start < end){
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    public static void swap(int start, int end, int nums[]){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}