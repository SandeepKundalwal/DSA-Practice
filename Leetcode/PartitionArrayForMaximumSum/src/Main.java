import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {1,15,7,9,2,5,10};
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int MEMO[] = new int[arr.length];
        Arrays.fill(MEMO, -1);
        return f(0,  arr, k, MEMO);
    }

    public static int f(int idx, int arr[], int k, int MEMO[]){
        if(idx >= arr.length){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        int currMax = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int i = idx; i < Math.min(arr.length, idx + k); i++){
            currMax = Math.max(currMax, arr[i]);
            maxSum = Math.max(maxSum, currMax * (i - idx + 1) + f(i + 1, arr, k, MEMO));
        }

        return MEMO[idx] = maxSum;
    }
}