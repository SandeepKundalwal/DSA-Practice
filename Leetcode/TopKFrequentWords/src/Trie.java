import java.util.*;

public class Trie{
    final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode trieNode = root;
        for(char c : word.toCharArray()){
            if(!trieNode.contains(c)){
                trieNode.put(c, new TrieNode());
            }
            trieNode = trieNode.get(c);
        }
        trieNode.word = word;
        trieNode.frequency += 1;
    }

    public void findFrequency(TrieNode trieNode, Map<Integer, List<String>> hashMap){
        if(trieNode.word != null){
            if(!hashMap.containsKey(trieNode.frequency)){
                hashMap.put(trieNode.frequency, new ArrayList<>());
            }
            hashMap.get(trieNode.frequency).add(trieNode.word);
        }

        for(int i = 0; i < 26; i++){
            if(trieNode.links[i] != null){
                findFrequency(trieNode.links[i], hashMap);
            }
        }
    }
}