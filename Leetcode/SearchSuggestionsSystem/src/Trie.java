import java.util.ArrayList;
import java.util.List;

public class Trie{
    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insertWords(String products[]){
        for(String product : products){
            TrieNode trieNode = root;
            for(char character : product.toCharArray()){
                if(!trieNode.contains(character)){
                    trieNode.put(character, new TrieNode());
                }
                trieNode = trieNode.get(character);
            }
            trieNode.isEnd = true;
        }
    }

    public List<String> getWordStartingWith(StringBuilder prefix){
        TrieNode trieNode = root;
        List<String> suggestion = new ArrayList<>();

        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!trieNode.contains(c)){
                return suggestion;
            }
            trieNode = trieNode.get(c);
        }

        findSuggestions(trieNode, suggestion, prefix);
        return suggestion;
    }

    public void findSuggestions(TrieNode trieNode, List<String> suggestion, StringBuilder word){
        if(suggestion.size() == 3){
            return;
        }

        if(trieNode.isEnd){
            suggestion.add(word.toString());
        }

        for(int i = 0; i < 26; i++){
            if(trieNode.links[i] != null){
                word.append((char)(i + 'a'));
                findSuggestions(trieNode.links[i], suggestion, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}