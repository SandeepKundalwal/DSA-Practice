public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insertWord(String word){
        TrieNode trieNode = root;
        for(char character : word.toCharArray()){
            if(trieNode.contains(character) == null){
                trieNode.put(character, new TrieNode());
            }
            trieNode = trieNode.get(character);
        }
        trieNode.isEnd = true;
    }

    public boolean searchWord(String word){
        TrieNode trieNode = root;
        for(char character : word.toCharArray()){
            if(trieNode.contains(character) == null){
                return false;
            }
            trieNode = trieNode.get(character);
        }
        return trieNode.isEnd == true;
    }

    public boolean startsWith(String prefix){
        TrieNode trieNode = root;
        for(char character : prefix.toCharArray()){
            if(trieNode.contains(character) == null){
                return false;
            }
            trieNode.get(character);
        }
        return true;
    }

    public String getLongestPrefix(String word){
        TrieNode trieNode = root;
        StringBuilder longestPrefix = new StringBuilder();

        for(char character : word.toCharArray()){
            if(trieNode.contains(character) != null && trieNode.getSize() == 1 && trieNode.isEnd == false){
                longestPrefix.append(character);
                trieNode = trieNode.get(character);
            } else {
                return longestPrefix.toString();
            }
        }
        return longestPrefix.toString();
    }
}
