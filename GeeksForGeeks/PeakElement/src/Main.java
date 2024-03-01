public class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int n = arr.length;
        System.out.println(peakElement(arr, n));
    }

    public static int peakElement(int[] arr,int n)
    {
        //add code here.
        // find the point of rotation in Sorted Array
        int nArr[] = new int[n + 2];
        nArr[0] = nArr[n + 1] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            nArr[i + 1] = arr[i];
        }

        int left = 1, right = n;
        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(nArr[mid - 1] <= nArr[mid] && nArr[mid + 1] <= nArr[mid]){
                return mid - 1;
            } else if(nArr[mid + 1] >= nArr[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}