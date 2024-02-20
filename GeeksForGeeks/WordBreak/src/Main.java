import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        String A = "leetcode";
//        List<String> B = List.of("leet", "code");
//        String A = "catsandog";
//        List<String> B = List.of("cats","dog","sand","and","cat");
//        String A = "ilike";
//        List<String> B = List.of( "i", "like", "sam", "sung", "samsung", "mobile");
//        String A = "catskicatcats";
//        List<String> B = List.of("cats","cat","dog","ski");

        String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> B = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println("Memoization: " + wordBreak(A, B));
        System.out.println("Trie: " + wordBreakTrie(A, B));
    }

    static Trie trie;
    public static int wordBreakTrie(String A, List<String> B)
    {
        trie = new Trie();
        for(String word : B){
            trie.insert(word);
        }

        Map<Integer, Boolean> MEMO = new HashMap<>();
        return trie.fTrie(0, trie.root, A, MEMO) ? 1 : 0;
    }

    // Memoization
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