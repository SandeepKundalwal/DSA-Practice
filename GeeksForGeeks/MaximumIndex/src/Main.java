import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 9;
        int a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(a, n));
    }

    static int maxIndexDiff(int a[], int n) {
        int maxi = 0;
        int t[] = new int[n];
        for(int i = n - 1; i >= 0; i--){
            maxi = Math.max(maxi, a[i]);
            t[i] = maxi;
        }

        int ans = 0;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(possible(mid, a, t, n)){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean possible(int diff, int a[], int t[], int n){
        for(int i = 0; i < n - diff; i++){
            if(a[i] <= t[i + diff]){
                return true;
            }
        }
        return false;
    }
}