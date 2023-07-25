public class Main {
    public static void main(String[] args) {
        int arr[] = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    /**
     1. Need to check for an index with arr[i - 1] < arr[i] > arr[i + 1]
     a. Take care of mid in case of 0 and n - 1
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = left + ((right - left) / 2);
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]){
                return mid;
            } else if(mid + 1 < arr.length && arr[mid] < arr[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}