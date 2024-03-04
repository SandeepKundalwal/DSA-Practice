import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int arr[] = {1,2,3};
        swapElements(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void swapElements(int[] arr, int n) {
        for(int i = 0; i < n - 2; i++){
            int temp = arr[i];
            arr[i] = arr[i + 2];
            arr[i + 2] = temp;
        }
    }
}