import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int happiness[] = {1,1,1,1};
        int k = 2;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        int dH = 0;
        long ans = 0;
        for(int i = happiness.length - 1; i >= 0; i--){
            if(k > 0){
                int happinessCollected = happiness[i] - dH;
                if(happinessCollected >= 0){
                    ans += happinessCollected;

                }
            }
            k--;
            dH++;
        }
        return ans;
    }
}