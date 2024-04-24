import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int sIdx = s.length();
        int pIdx = p.length();
        Map<String, Boolean> MEMO = new HashMap<>();

        return f(sIdx - 1, pIdx - 1, s, p, MEMO);
    }

    public static boolean f(int sIdx, int pIdx, String s, String p, Map<String, Boolean> MEMO){
        if(sIdx < 0 && pIdx < 0){
            return true;
        }

        if(pIdx < 0){
            return false;
        }

        if(sIdx < 0){
            while(pIdx >= 0){
                if(p.charAt(pIdx) != '*'){
                    return false;
                }
                pIdx--;
            }
            return true;
        }

        String key = sIdx + "|" + pIdx;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        boolean ans = false;
        if(p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx)){
            ans |= f(sIdx - 1, pIdx - 1, s, p, MEMO);
        }

        if(p.charAt(pIdx) == '*'){
            ans |= (f(sIdx, pIdx - 1, s, p, MEMO) || f(sIdx - 1, pIdx, s, p, MEMO));
        }

        MEMO.put(key, ans);
        return ans;
    }
}