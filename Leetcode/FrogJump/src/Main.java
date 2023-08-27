import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Input Format:
        8
        0 1 3 5 6 8 12 17
         */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int stones[] = new int[n];
        for(int i = 0; i < n; i++){
            stones[i] = in.nextInt();
        }

        System.out.println(canCross(stones));
    }

    // Can jump either k - 1, k or k + 1 units, if the last jump was k units
    private static boolean canCross(int[] stones) {
        if(stones.length == 2){
            return stones[1] - stones[0] == 1;
        }

        if(stones[1] - stones[0] != 1){
            return false;
        }

        Map<String, Boolean> MEMO = new HashMap<>();
        return f(1, 1, stones, MEMO);
    }

    private static boolean f(int idx, int lastK, int stones[], Map<String, Boolean> MEMO){
        if(idx == stones.length - 1){
            return true;
        }

        String key = idx + "|" + lastK;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        boolean isPossible = false;
        for(int i = idx; i < stones.length - 1; i++){
            // move k - 1 unit;
            if(stones[idx] + (lastK - 1) == stones[i + 1] && f(i + 1, lastK - 1, stones, MEMO)){
                isPossible = true;
                break;
            }

            // move k units;
            if(stones[idx] + lastK == stones[i + 1] && f(i + 1, lastK, stones, MEMO)){
                isPossible = true;
                break;
            }

            // move k + 1 units;
            if(stones[idx] + (lastK + 1) == stones[i + 1] &&  f(i + 1, lastK + 1, stones, MEMO)){
                isPossible = true;
                break;
            }
        }

        MEMO.put(key, isPossible);
        return isPossible;
    }
}