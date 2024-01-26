public class TrieNode {
    int size;
    TrieNode links[];
    boolean isEnd;

    public TrieNode(){
        size = 0;
        links = new TrieNode[26];
        isEnd = false;
    }

    public int getSize(){
        return size;
    }

    public TrieNode contains(char character){
        return links[character - 'a'];
    }

    public void put(char character, TrieNode trieNode){
        links[character - 'a'] = trieNode;
        size++;
    }

    public TrieNode get(char character){
        return links[character - 'a'];
    }
}
