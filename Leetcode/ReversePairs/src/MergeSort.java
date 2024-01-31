public class MergeSort {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    public int mergeSort(int start, int end, int nums[]){
        int count = 0;
        if(start < end){
            int mid = start + ((end - start) / 2);
            count += mergeSort(start, mid, nums);
            count += mergeSort(mid + 1, end, nums);
            count += checkPairs(start, mid, end, nums);
            merge(start, mid, end, nums);
        }
        return count;
    }

    public int checkPairs(int start, int mid, int end, int nums[]){
        int count = 0;
        int right = mid + 1;
        for(int i = start; i <= mid; i++){
            while(right <= end && nums[i] > (long) 2 * nums[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    public void merge(int start, int mid, int end, int nums[]){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i = 0; i < n1; i++){
            left[i] = nums[start + i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = nums[mid + j + 1];
        }

        int i = 0, j = 0, k = start;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                nums[k] = left[i++];
            } else {
                nums[k] = right[j++];
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
