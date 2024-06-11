import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int frequency[] = new int[1001];
        for(int num : arr1){
            frequency[num]++;
        }

        int idx = 0;
        for(int i = 0; i < arr2.length; i++){
            while(frequency[arr2[i]] > 0){
                arr1[idx++] = arr2[i];
                frequency[arr2[i]]--;
            }
        }

        for(int i = 0; i < 1001; i++){
            while(frequency[i] > 0){
                arr1[idx++] = i;
                frequency[i]--;
            }
        }

        return arr1;
    }
}