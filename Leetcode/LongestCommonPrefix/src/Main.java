public class Main {
    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
        Trie trie = new Trie();
        for(String word : strs){
            trie.insertWord(word);
        }

        System.out.println(trie.getLongestPrefix(strs[0]));
    }
}