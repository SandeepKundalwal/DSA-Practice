public class Main {
    public static void main(String[] args) {
        int nums[] = {2,1,3,4};
        int k = 1;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int XORed = 0;
        for(int num : nums){
            XORed ^= num;
        }

        int count = 0;
        for(int bit = 0; bit < 32; bit++){
            if((k & (1 << bit)) != (XORed & (1 << bit))){
                count++;
            }
        }

        return count;
    }
}