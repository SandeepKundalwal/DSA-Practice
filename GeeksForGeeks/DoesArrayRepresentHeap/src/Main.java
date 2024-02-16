public class Main {
    public static void main(String[] args) {
        int n = 6;
        long arr[] = {90,15,10,7,12,2};
        System.out.println(countSub(arr, n));
    }

    public static boolean countSub(long arr[], long n)
    {
        for(int i = 0; i < n; i++){
            int leftIdx = 2*i+1;
            int rightIdx = 2*i+2;

            if(leftIdx < n){
                if(arr[leftIdx] > arr[i]){
                    return false;
                }
            }

            if(rightIdx < n){
                if(arr[rightIdx] > arr[i]){
                    return false;
                }
            }
        }

        return true;
    }
}