import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        int rightmostSetBit = (xor & (xor - 1)) ^ xor;

        int answer[] = new int[2];
        for(int num : nums){
            if((num & rightmostSetBit) == 0){
                answer[0] ^= num;
            } else {
                answer[1] ^= num;
            }
        }

        return answer;
    }
}