public class Main {
    public static void main(String[] args) {
        int nums[] = {5,4,2,6,7};
        System.out.println(maxProductDifference(nums));
    }

    public static int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num;
            } else if (num  > max2){
                max2 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            } else if(num < min2){
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }
}