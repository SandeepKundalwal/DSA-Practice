import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int position[] = {1,2,4,999999998,999999999,1000000000};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int ans = 0;
        int low = 0, high = position[position.length - 1];
        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(isPossible(mid, position, m)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int distance, int position[], int m){
        int n = position.length;

        // System.out.println(distance + ": ");

        int count = 0;
        for(int i = 0; i < n;){
            int nI = i + 1;
            while(nI < n && Math.abs(position[i] - position[nI]) < distance) nI++;

            count++;

            if(count >= m) return true;

            i = nI;
        }

        // System.out.println("count: " + count);
        return count >= m;
    }
}