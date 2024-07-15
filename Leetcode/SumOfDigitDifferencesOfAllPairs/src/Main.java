public class Main {
    public static void main(String[] args) {
        int nums[] = {13,23,12};
        System.out.println(sumDigitDifferences(nums));
    }

    public static long sumDigitDifferences(int[] nums) {
        long ans = 0;
        while(nums[0] > 0){
            int digits[] = new int[10];
            for(int i = 0; i < nums.length; i++){
                int digit = nums[i] % 10;
                nums[i] = nums[i] / 10;
                digits[digit]++;
            }

            for(int i = 0; i < 10; i++){
                if(digits[i] > 0){
                    for(int j = i + 1; j < 10; j++){
                        if(digits[j] > 0){
                            ans += ((long)digits[i] * digits[j]);
                        }
                    }
                }
            }
        }

        return ans;
    }
}