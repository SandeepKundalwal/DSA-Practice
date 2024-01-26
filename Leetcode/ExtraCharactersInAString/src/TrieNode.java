public class TrieNode {
    private TrieNode links[];
    private boolean isEnd;

    public TrieNode(){
        this.links = new TrieNode[26];
        this.isEnd = false;
    }

    public boolean contains(char character){
        return this.links[character - 'a'] != null;
    }

    public TrieNode get(char character){
        return this.links[character - 'a'];
    }

    public void put(char character, TrieNode trieNode){
        this.links[character - 'a'] = trieNode;
    }

    public void setEnd(){
        this.isEnd = true;
    }

    public boolean isEnd(){
        return this.isEnd;
    }
}
