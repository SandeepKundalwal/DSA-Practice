import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {5,3,2,4};
        System.out.println(minDifference(nums));
    }

    public static int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 3){
            return 0;
        }

        int firstFour[] = findMinFour(nums);
        int lastFour[]  = findMaxFour(nums);

        int mini = lastFour[0] - firstFour[3];
        mini = Math.min(mini, lastFour[3] - firstFour[0]);
        mini = Math.min(mini, lastFour[2] - firstFour[1]);
        mini = Math.min(mini, lastFour[1] - firstFour[2]);

        return mini;
    }

    public static int[] findMinFour(int nums[]){
        int firstFour[] = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        for(int num : nums){
            if(firstFour[0] >= num){
                firstFour[3] = firstFour[2];
                firstFour[2] = firstFour[1];
                firstFour[1] = firstFour[0];
                firstFour[0] = num;
            } else if(firstFour[1] >= num){
                firstFour[3] = firstFour[2];
                firstFour[2] = firstFour[1];
                firstFour[1] = num;
            } else if(firstFour[2] >= num){
                firstFour[3] = firstFour[2];
                firstFour[2] = num;
            } else if(firstFour[3] >= num){
                firstFour[3] = num;
            }
        }

        return firstFour;
    }

    public static int[] findMaxFour(int nums []){
        int lastFour[]  = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int num : nums){
            if(lastFour[0] <= num){
                lastFour[3] = lastFour[2];
                lastFour[2] = lastFour[1];
                lastFour[1] = lastFour[0];
                lastFour[0] = num;
            } else if(lastFour[1] <= num){
                lastFour[3] = lastFour[2];
                lastFour[2] = lastFour[1];
                lastFour[1] = num;
            } else if(lastFour[2] <= num){
                lastFour[3] = lastFour[2];
                lastFour[2] = num;
            } else if(lastFour[3] <= num){
                lastFour[3] = num;
            }
        }

        return lastFour;
    }
}