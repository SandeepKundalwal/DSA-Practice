import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> dictionary = List.of("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for(String word : dictionary){
            trie.insertWord(word);
        }

        StringBuilder newSentence = new StringBuilder();
        for(String word : sentence.split(" ")){
            newSentence.append(trie.shortestWord(word)).append(" ");
        }

        return newSentence.toString().trim();
    }

    static class TrieNode{
        boolean isEnd;
        TrieNode links[];

        public TrieNode(){
            this.isEnd = false;
            this.links = new TrieNode[26];
        }

        public void setEnd(){
            this.isEnd = true;
        }

        public boolean getEnd(){
            return this.isEnd;
        }

        public TrieNode get(char c){
            return this.links[c - 'a'];
        }

        public void put(char c, TrieNode node){
            this.links[c - 'a'] = node;
        }


        public boolean contains(char c){
            return this.links[c - 'a'] != null;
        }
    }

    static class Trie{
        TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insertWord(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(!node.contains(c)){
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        public String shortestWord(String word){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!node.contains(c)){
                    break;
                }

                node = node.get(c);
                if(node.getEnd()){
                    return word.substring(0, i + 1);
                }
            }
            return word;
        }
    }
}