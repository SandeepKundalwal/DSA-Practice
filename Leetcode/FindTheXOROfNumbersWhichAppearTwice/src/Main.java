public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,1,3};
        System.out.println(duplicateNumbersXOR(nums));
    }

    public static int duplicateNumbersXOR(int[] nums) {
        int freq[] = new int[51];
        for(int num : nums){
            freq[num]++;
        }

        int xor = 0;
        for(int i = 1; i < 51; i++){
            if(freq[i] == 2){
                xor ^= i;
            }
        }

        return xor;
    }
}