class TrieNode{
    private TrieNode links[];
    private boolean isEnd;

    public TrieNode(){
        this.links = new TrieNode[26];
        this.isEnd = false;
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

    public void setEnd(){
        this.isEnd = true;
    }

    public boolean getEnd(){
        return this.isEnd;
    }
}