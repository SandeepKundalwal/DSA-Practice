public class QuickSelect {
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(0, nums.length - 1, nums, k);
    }

    public static int quickSort(int start, int end, int nums[], int k){
        int kthSmallest = -100001;
        if(start <= end){
            int pivot = findPivot(start, end, nums);

            if(nums.length - k == pivot){
                return nums[pivot];
            } else if(pivot < nums.length - k){
                kthSmallest = quickSort(pivot + 1, end, nums, k);
            } else {
                kthSmallest = quickSort(start, pivot - 1, nums, k);
            }
        }
        return kthSmallest;
    }

    public static int findPivot(int start, int end, int nums[]){
        int pivot = nums[end];

        int idx = start - 1;
        for(int i = start; i <= end - 1; i++){
            if(nums[i] < pivot){
                idx++;
                swap(idx, i, nums);
            }
        }
        idx++;
        swap(idx, end, nums);
        return idx;
    }

    public static void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
