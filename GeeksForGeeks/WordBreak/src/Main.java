import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String A = "ilike";
        List<String> B = List.of("i", "like", "sam", "sung", "samsung", "mobile");
        System.out.println(wordBreak(A, B));
    }

    public static int wordBreak(String A, List<String> B )
    {
        Set<String> dict = new HashSet<>(B);
        Map<String, Boolean> MEMO = new HashMap<>();
        return f(0, new String(), A, dict, MEMO) ? 1 : 0;
    }


    public static boolean f(int idx, String prefix, String A, Set<String> dict, Map<String, Boolean> MEMO){
        if(idx >= A.length()){
            return true;
        }


        String key = prefix + "|" + idx;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        boolean ans = false;
        for(int i = idx; i <= A.length(); i++){
            String currPrefix = A.substring(idx, i);
            if(dict.contains(currPrefix)){
                if(f(i, currPrefix, A, dict, MEMO)){
                    ans = true;
                }
            }
        }

        MEMO.put(key, ans);
        return ans;
    }
}