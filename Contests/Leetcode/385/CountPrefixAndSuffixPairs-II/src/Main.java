import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String words[] = {"a","aba","ababa","aa"};
        System.out.println(countPrefixSuffixPairs(words));
    }

    public static long countPrefixSuffixPairs(String[] words) {
        Trie trie = new Trie();

        long ans = 0;
        for(String word : words){
            int n = word.length();
            TrieNode node = trie.root;
            for(int i = 0; i < n; i++){
                int hash = word.charAt(i) * 128 + word.charAt(n - 1 - i);
                if(!node.contains(hash)){
                    node.put(hash, new TrieNode());
                }
                node = node.get(hash);
                ans += node.counter;
            }
            node.counter++;
        }
        return ans;
    }

    static class TrieNode{
        int counter;
        Map<Integer, TrieNode> links;

        public TrieNode(){
            this.counter = 0;
            this.links = new HashMap<>();
        }

        public boolean contains(int hash){
            return this.links.containsKey(hash);
        }

        public void put(int hash, TrieNode trieNode){
            this.links.put(hash, trieNode);
        }

        public TrieNode get(int hash){
            return this.links.get(hash);
        }
    }

    static class Trie{
        TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }
    }
}