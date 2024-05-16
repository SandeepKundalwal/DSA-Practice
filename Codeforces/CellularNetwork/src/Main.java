import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int cities[] = new int[n];
        for(int i = 0; i < n; i++){
            cities[i] = in.nextInt();
        }

        int towers[] = new int[m];
        for(int i = 0; i < m; i++){
            towers[i] = in.nextInt();
        }

        System.out.println(findRadius(n, cities, m, towers));
    }

    public static long findRadius(int n, int cities[], int m, int towers[]){
        long left = 0, right = Math.abs(cities[n - 1]) + Math.abs(towers[m - 1]);

        long ans = 0;
        while(left <= right){
            long mid = left + ((right - left) >> 1);

            if(possibleToCoverArea(mid, cities, towers)){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean possibleToCoverArea(long radius, int cities[], int towers[]){
        int cIdx = 0;
        for(int i = 0; i < towers.length; i++){
            if(cIdx >= cities.length){
                return true;
            }

            long leftC = towers[i] - radius;
            long rightC = towers[i] + radius;

            while(cIdx < cities.length && cities[cIdx] >= leftC && cities[cIdx] <= rightC){
                cIdx++;
            }
        }
        return cIdx >= cities.length;
    }
}