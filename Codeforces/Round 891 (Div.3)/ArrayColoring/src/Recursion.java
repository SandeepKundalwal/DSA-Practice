import java.util.Map;

public class Recursion {
    public static boolean isPossible(int index, boolean redUsed, boolean blueUsed, int redSum, int blueSum, int a[], Map<String, Boolean> MEMO){
        if(index == a.length){
            if(redUsed && blueUsed){
                return (redSum % 2 == blueSum % 2);
            }
            return false;
        }

        String key = index + "|" + redUsed + "|" + blueUsed + "|" + redSum + "|" + blueSum;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        boolean ans = isPossible(index + 1, true, blueUsed, redSum + a[index], blueSum, a, MEMO) || isPossible(index + 1, redUsed, true, redSum, blueSum + a[index], a, MEMO);

        MEMO.put(key, ans);
        return ans;
    }
}
