import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        System.out.println("Is it possible: " + wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictionary = new HashSet<>();
        for(String word : wordDict){
            wordDictionary.add(word);
        }

        Map<String, Boolean> MEMO = new HashMap<>();

        return isPossible(0, s, new String(), wordDictionary, MEMO);
    }

    public static boolean isPossible(int idx, String s, String prefix, Set<String> wordDictionary, Map<String, Boolean> MEMO){
        if(idx == s.length()){
            return true;
        }

        String key = idx + "|" + prefix;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        boolean ans = false;
        for(int i = idx; i <= s.length(); i++){
            String currentPrefix = s.substring(idx, i);
            if(wordDictionary.contains(currentPrefix) && isPossible(i, s, currentPrefix, wordDictionary, MEMO)){
                ans = true;
            }
        }

        MEMO.put(key, ans);
        return ans;
    }
}