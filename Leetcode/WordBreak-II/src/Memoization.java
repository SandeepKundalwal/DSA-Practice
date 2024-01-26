import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memoization {
    Map<String, List<String>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        return wordBreakUtility(s, wordDict);
    }

    public List<String> wordBreakUtility(String s, List<String> wordDict){
        if(memo.containsKey(s)){
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if(s.length() == 0){
            result.add("");
            return result;
        }

        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> previous = wordBreakUtility(s.substring(word.length()), wordDict);
                for(String prev : previous){
                    result.add(word + ((prev.length() == 0) ? "" : " ") + prev);
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}
