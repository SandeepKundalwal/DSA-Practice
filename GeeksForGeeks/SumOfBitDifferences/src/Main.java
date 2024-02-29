public class Main {
    public static void main(String[] args) {
        int n = 4;
        int arr[] = {1,3,5,7};
        System.out.println(sumBitDifferences(arr, n));
    }

    static long sumBitDifferences(int[] arr, int n) {
        long bitDifference = 0;
        for(int k = 0; k < 32; k++){
            long setBits = 0;
            long unsetBits = 0;
            for(int i = 0; i < n; i++){
                if((arr[i] & (1 << k)) == 0){
                    unsetBits++;
                } else {
                    setBits++;
                }
            }
            bitDifference += ((setBits * unsetBits) * 2);
        }
        return bitDifference;
    }
}