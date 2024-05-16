import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int houses[] = {1,2,3,4};
        int heaters[] = {1,4};
        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        int m = houses.length;
        int n = heaters.length;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0, right = Math.max(houses[m - 1], heaters[n - 1]);

        int ans = 0;
        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(possibleToWarmHouses(mid, houses, heaters)){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean possibleToWarmHouses(int radius, int houses[], int heaters[]){
        int hIdx = 0;
        for(int i = 0; i < heaters.length; i++){
            if(hIdx >= houses.length){
                return true;
            }

            int leftC = heaters[i] - radius;
            int rightC = heaters[i] + radius;

            while(hIdx < houses.length && houses[hIdx] >= leftC && houses[hIdx] <= rightC){
                hIdx++;
            }
        }
        return hIdx >= houses.length;
    }
}