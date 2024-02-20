class Trie{
    TrieNode root;

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
        trieNode.isEnd = true;
    }
}