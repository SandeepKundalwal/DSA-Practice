import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("is it possible? " + isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();

        if(m == 0){
            return s3.equals(s2);
        } else if(n == 0){
            return s3.equals(s1);
        }

        Map<String, Boolean> MEMO = new HashMap<>();
        return f(m - 1, n - 1, o - 1, s1, s2, s3, MEMO);
    }

    public static boolean f(int i, int j, int k, String s1, String s2, String s3, Map<String, Boolean> MEMO){
        if(k == 0){
            if(i < 0 && j == 0) return s2.charAt(j) == s3.charAt(k);
            if(i == 0 && j < 0) return s1.charAt(i) == s3.charAt(k);
            return false;
        }

        String key = i + "|" + j + "|" + k;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        boolean ans = false;
        if(i >= 0 && s1.charAt(i) == s3.charAt(k)){
            ans = f(i - 1, j, k - 1, s1, s2, s3, MEMO);
        }

        if(j >= 0 && s2.charAt(j) == s3.charAt(k)){
            ans = ans || f(i, j - 1, k - 1, s1, s2, s3, MEMO);
        }

        MEMO.put(key, ans);
        return ans;
    }
}