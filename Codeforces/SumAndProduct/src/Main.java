import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 1; i <= t; i++){
            int n = in.nextInt();
            int a[] = new int[n];
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for(int j = 0; j < n; j++){
                a[j] = in.nextInt();

                if(frequencyMap.containsKey(a[j])){
                    frequencyMap.put(a[j], frequencyMap.get(a[j]) + 1);
                } else {
                    frequencyMap.put(a[j], 1);
                }
            }

            Arrays.sort(a);

            int q = in.nextInt();
            for(int j = 0; j < q; j++){
                long x = in.nextLong();
                long y = in.nextLong();

                long ans = Maths.findPairs(x, y, n, a, frequencyMap);
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}