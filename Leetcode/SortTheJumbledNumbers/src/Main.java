import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int mapping[] = {9,8,7,6,5,4,3,2,1,0};
        int nums[] = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        mergeSort(0, nums.length - 1, nums, mapping);
        return nums;
    }

    public static void mergeSort(int start, int end, int nums[], int mapping[]){
        if(start < end){
            int mid = start + ((end - start) / 2);

            mergeSort(start, mid, nums, mapping);
            mergeSort(mid + 1, end, nums, mapping);
            merge(start, mid, end, nums, mapping);
        }
    }

    public static void merge(int start, int mid, int end, int nums[], int mapping[]){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        int idx = 0;
        for(int i = start; i <= mid; i++){
            left[idx++] = nums[i];
        }

        idx = 0;
        for(int i = mid + 1; i <= end; i++){
            right[idx++] = nums[i];
        }

        int i = 0, j = 0, k = start;
        while(i < n1 && j < n2){
            if(compareIntegers(left[i], right[j], mapping) == 1){
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while(i < n1){
            nums[k++] = left[i++];
        }

        while(j < n2){
            nums[k++] = right[j++];
        }
    }

    public static int compareIntegers(int a, int b, int mapping[]){
        int newA = mapping[a % 10];
        a /= 10;
        int digit = 10;
        while(a > 0){
            newA += (digit * mapping[a % 10]);
            digit *= 10;
            a /= 10;
        }

        int newB = mapping[b % 10];
        b /= 10;
        digit = 10;
        while(b > 0){
            newB += (digit * mapping[b % 10]);
            digit *= 10;
            b /= 10;
        }

        return newA <= newB ? 1 : -1;
    }
}