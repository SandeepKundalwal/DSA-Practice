import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int bloomDay[] = {1,10,2,9,3,8,4,7,5,6};
        int m = 4;
        int k = 2;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        // don't have enough flowers
        if((long)m * k > bloomDay.length) return -1;

        int ans = -1;
        int low = 0, high = Arrays.stream(bloomDay).max().getAsInt();
        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(isPossible(mid, bloomDay, m, k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int days, int bloomDay[], int m, int k){
        int n = bloomDay.length;

        int idx = 0;
        int count = 0;
        while(idx < n){
            int flowersTaken = 0;
            int kLimit = idx + k;
            while(idx < n && idx < kLimit){
                if(bloomDay[idx] <= days){
                    flowersTaken++;
                    idx++;
                } else {
                    break;
                }
            }

            if(flowersTaken == k){
                count++;
            } else {
                idx++;
            }
        }

        return count >= m;
    }
}