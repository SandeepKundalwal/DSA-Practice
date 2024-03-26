import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,3,-1,-2};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int missingPositive = 1;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                if(nums[i] == missingPositive){
                    int j = i;
                    while(j < nums.length && nums[j] == missingPositive) j++;
                    i = j - 1;
                    missingPositive++;
                } else {
                    break;
                }
            }
        }

        return missingPositive;
    }
}