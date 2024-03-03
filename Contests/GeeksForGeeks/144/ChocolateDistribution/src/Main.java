import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int N = 3;
        int arr[] = {1,2,3};
        int M = 2;
        int brr[] = {1,1};
        System.out.println(chocolateDistribution(N, M, arr, brr));
    }

    public static int chocolateDistribution(int N, int M, int[] arr, int[] brr) {
        // code here
        Arrays.sort(arr);
        Arrays.sort(brr);

        int count = 0;
        int i = N - 1, j = M - 1;
        while(i >= 0 && j >= 0){
            if(arr[i] <= brr[j]){
                count++;
                i--;
                j--;
            } else {
                i--;
            }
        }

        return count;
    }
}