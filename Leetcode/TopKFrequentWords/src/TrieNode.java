public class TrieNode{
    String word;
    int frequency;
    TrieNode links[];

    public TrieNode(){
        this.word = null;
        this.frequency = 0;
        this.links = new TrieNode[26];
    }

    public TrieNode get(char c){
        return this.links[c - 'a'];
    }

    public boolean contains(char c){
        return this.links[c - 'a'] != null;
    }

    public void put(char c, TrieNode trieNode){
        this.links[c - 'a'] = trieNode;
    }
}