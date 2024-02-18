public class Main {
    public static void main(String[] args) {
        int arr1[] = {1,10,100};
        int arr2[] = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int i : arr1){
            trie.insert(Integer.toString(i));
        }

        int maxi = 0;
        for(int i : arr2){
            maxi = Math.max(maxi, trie.findPrefix(Integer.toString(i)));
        }
        return maxi;
    }

    static class TrieNode{
        TrieNode links[];
        boolean isEnd;

        public TrieNode(){
            this.links = new TrieNode[10];
            this.isEnd = false;
        }

        public boolean contains(int no){
            return this.links[no] != null;
        }

        public void put(int no, TrieNode node){
            this.links[no] = node;
        }

        public TrieNode get(int no){
            return this.links[no];
        }
    }

    static class Trie{
        TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String no){
            TrieNode node = root;
            for(char c : no.toCharArray()){
                if(!node.contains(c - '0')){
                    node.put(c - '0', new TrieNode());
                }
                node = node.get(c - '0');
            }
            node.isEnd = true;
        }

        public int findPrefix(String no){
            TrieNode node = root;
            int len = 0;
            for(char c : no.toCharArray()){
                if(!node.contains(c - '0')){
                    break;
                }
                node = node.get(c - '0');
                len++;
            }
            return len;
        }
    }
}