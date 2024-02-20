class TrieNode{
    TrieNode links[];
    boolean isEnd;

    public TrieNode(){
        this.links = new TrieNode[26];
        isEnd = false;
    }

    public boolean contains(char c){
        return this.links[c - 'a'] != null;
    }

    public void put(char c, TrieNode trieNode){
        this.links[c - 'a'] = trieNode;
    }

    public TrieNode get(char c){
        return this.links[c - 'a'];
    }
}