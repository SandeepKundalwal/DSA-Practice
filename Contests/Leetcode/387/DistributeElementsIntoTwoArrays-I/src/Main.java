import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {5,4,3,8};
        System.out.println(Arrays.toString(resultArray(nums)));
    }

    public static int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++){
            int arr1LE = arr1.get(arr1.size() - 1);
            int arr2LE = arr2.get(arr2.size() - 1);

            if(arr1LE > arr2LE){
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        int idx = 0;
        for(int e : arr1){
            nums[idx++] = e;
        }

        for(int e : arr2){
            nums[idx++] = e;
        }

        return nums;
    }
}