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