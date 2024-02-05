import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {8,4,2};
        System.out.println(triangleType(nums));
    }

    public static String triangleType(int[] nums) {
        Arrays.sort(nums);
        int first = nums[0];
        int second = nums[1];
        int third = nums[2];


        if(first == second && second == third){
            return "equilateral";
        } else if((first + second > third) && (first == second || second == third)){
            return "isosceles";
        } else {
            if(first + second <= third){
                return "none";
            } else {
                return "scalene";
            }
        }
    }
}