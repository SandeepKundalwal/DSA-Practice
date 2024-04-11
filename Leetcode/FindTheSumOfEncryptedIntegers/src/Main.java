public class Main {
    public static void main(String[] args) {
        int nums[] = {10,21,31};
        System.out.println(sumOfEncryptedInt(nums));
    }

    public static int sumOfEncryptedInt(int[] nums) {
        int sum = 0;

        for(int num : nums){
            int maxElement = 0;
            int originalNum = num;
            while(num > 0){
                maxElement = Math.max(maxElement, num % 10);
                num /= 10;
            }

            if(originalNum < 10){
                sum += (maxElement);
            } else if(originalNum < 100){
                sum += ((10 * maxElement) + maxElement);
            } else if(originalNum < 1000){
                sum += ((100 * maxElement) + (10 * maxElement) + maxElement);
            } else {
                sum += ((1000 * maxElement) + (100 * maxElement) + (10 * maxElement) + maxElement);
            }
        }

        return sum;
    }
}