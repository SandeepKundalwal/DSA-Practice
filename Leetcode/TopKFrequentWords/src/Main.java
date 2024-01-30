import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        String words[] = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        TrieNode trieNode = trie.root;
        Map<Integer, List<String>> hashMap = new HashMap<>();
        trie.findFrequency(trieNode, hashMap);

        List<Integer> sortedKeys = new ArrayList<>(hashMap.keySet());

        List<String> result = new ArrayList<>();
        outer: for(int i = sortedKeys.size() - 1; i >= 0; i--){
            List<String> wordList = hashMap.get(sortedKeys.get(i));

            for(String word : wordList){
                if(k == 0){
                    break outer;
                }
                result.add(word);
                k--;
            }
        }
        return result;
    }
}