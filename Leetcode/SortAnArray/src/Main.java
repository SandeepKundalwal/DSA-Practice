import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {5,4,3,2,1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }

    public static void mergeSort(int start, int end, int nums[]){
        if(start < end){
            int mid = start + ((end - start) / 2);

            mergeSort(start, mid, nums);
            mergeSort(mid + 1, end, nums);
            merge(start, mid, end, nums);
        }
    }

    public static void merge(int start, int mid, int end, int nums[]){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        int l = 0;
        for(int i = start; i <= mid; i++){
            left[l++] = nums[i];
        }

        int m = 0;
        for(int i = mid + 1; i <= end; i++){
            right[m++] = nums[i];
        }

        int i = 0, j = 0, k = start;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            nums[k++] = left[i++];
        }

        while(j < n2){
            nums[k++] = right[j++];
        }
    }
}