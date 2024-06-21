public class Main {
    public static void main(String[] args) {
        int customers[] = {1, 0, 1, 2, 1, 1, 7, 5};
        int grumpy[] = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int gain = 0;
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0) gain += customers[i];
        }

        int minutesGain = 0;
        int maxMinutesGain = 0;

        int left = 0, right = 0;
        while(right < n){
            if(grumpy[right] == 1){
                minutesGain += customers[right];
            }

            if(right >= minutes){
                if(grumpy[left] == 1){
                    minutesGain -= customers[left];
                }
                left++;
            }

            maxMinutesGain = Math.max(minutesGain, maxMinutesGain);
            right++;
        }

        return gain + maxMinutesGain;
    }
}