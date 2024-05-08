import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums1[] = {2,6,4};
        int nums2[] = {9,7,5};
        System.out.println(addedInteger(nums1, nums2));
    }

    public static int addedInteger(int[] nums1, int[] nums2) {
        int sumA = Arrays.stream(nums1).sum();
        int sumB = Arrays.stream(nums2).sum();

        return (sumB - sumA) / nums1.length;
    }
}