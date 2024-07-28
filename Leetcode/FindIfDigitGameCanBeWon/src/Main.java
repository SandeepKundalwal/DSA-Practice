public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,10};
        System.out.println(canAliceWin(nums));
    }

    public static boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0, doubleDigitSum = 0;
        for(int num : nums){
            if(num < 10){
                singleDigitSum += num;
            } else {
                doubleDigitSum += num;
            }
        }

        return singleDigitSum != doubleDigitSum;
    }
}