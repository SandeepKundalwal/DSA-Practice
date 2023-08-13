import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int a[] = new int[n];
            for(int idx = 0; idx < n; idx++){
                a[idx] = in.nextInt();
            }

            Arrays.sort(a);
            System.out.println(isPossible(0, false, false, 0, a) ? "YES" : "NO");
        }
    }

    public static boolean isPossible(int index, boolean redUsed, boolean blueUsed, int SUM, int a[]){
        int redSum = 0, blueSum = 0;
        int left = 0, right = a.length - 1;
        int prevLeft = -1, prevRight = -1;
        while(left < right){
            if(left != prevLeft){
                redSum += a[left];
                prevLeft = left;
            }

            if(right != prevRight){
                blueSum += a[right];
                prevRight = right;
            }

            if(redSum - blueSum <= 0){
                left++;
            } else {
                right--;
            }
        }

        return (Math.abs(redSum - blueSum) % 2 == 0);
    }
}