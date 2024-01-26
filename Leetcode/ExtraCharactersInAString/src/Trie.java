public class Trie {
    final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode trieNode = root;
        for(char character : word.toCharArray()){
            if(trieNode.contains(character) == false){
                trieNode.put(character, new TrieNode());
            }
            trieNode = trieNode.get(character);
        }
        trieNode.setEnd();
    }
}
