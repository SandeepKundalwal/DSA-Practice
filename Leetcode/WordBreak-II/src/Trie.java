import java.util.ArrayList;
import java.util.List;

public class Trie {
    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public class TrieNode{
        TrieNode links[];
        boolean isEnd;

        public TrieNode(){
            this.links = new TrieNode[26];
            this.isEnd = false;
        }

        public boolean contains(char character){
            return this.links[character - 'a'] != null;
        }

        public void put(char character, TrieNode trieNode){
            this.links[character - 'a'] = trieNode;
        }

        public TrieNode get(char character){
            return this.links[character - 'a'];
        }
    }

    public void insert(List<String> wordDict){
        for(String word : wordDict){
            TrieNode trieNode = root;
            for(char character : word.toCharArray()){
                if(!trieNode.contains(character)){
                    trieNode.put(character, new TrieNode());
                }
                trieNode = trieNode.get(character);
            }
            trieNode.isEnd = true;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        insert(wordDict);

        List<String> sentences = new ArrayList<>();
        f(0, s, new StringBuilder(), sentences);
        return sentences;
    }

    public void f(int idx, String s, StringBuilder newS, List<String> sentences){
        if(idx >= s.length()){
            sentences.add(newS.toString().trim());
            return;
        }

        TrieNode trieNode = root;
        for(int i = idx; i < s.length(); i++){
            char character = s.charAt(i);

            if(!trieNode.contains(character)){
                break;
            }

            trieNode = trieNode.get(character);
            if(trieNode.isEnd){
                for(int j = idx; j < i + 1; j++) newS.append(s.charAt(j));
                f(i + 1, s, newS.append(" "), sentences);
                for(int j = idx; j < i + 2; j++) newS.deleteCharAt(newS.length() - 1);
            }
        }
    }
}


