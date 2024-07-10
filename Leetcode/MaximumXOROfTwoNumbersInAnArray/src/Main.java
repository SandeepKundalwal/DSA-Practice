public class Main {
    public static void main(String[] args) {
        int nums[] = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num : nums){
            trie.insert(num);
        }

        int result = 0;
        for(int num : nums){
            result = Math.max(result, trie.findXOR(num));
        }

        return result;
    }

    static class TrieNode{
        TrieNode links[];

        public TrieNode(){
            this.links = new TrieNode[2];
        }

        public boolean contains(int i){
            return this.links[i] != null;
        }

        public void put(int i, TrieNode trieNode){
            this.links[i] = trieNode;
        }

        public TrieNode get(int i){
            return this.links[i];
        }
    }

    static class Trie{
        TrieNode root;
        int currentXOR;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(int num){
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int set = (num & (1 << i)) == 0 ? 0 : 1;
                if(!node.contains(set)){
                    node.put(set, new TrieNode());
                }
                node = node.get(set);
            }
        }

        public int findXOR(int num){
            this.currentXOR = 0;
            return xor(31, num, root);
        }

        public int xor(int depth, int num, TrieNode node){
            if(depth < 0){
                return this.currentXOR;
            }

            // Optimally I should need the opposite bit of what the num have.
            int haveBit = (num & (1 << depth)) == 0 ? 0 : 1;
            int requiredBit = haveBit == 0 ? 1 : 0;

            if(node.contains(requiredBit)){
                this.currentXOR = (this.currentXOR | (1 << depth));
                return xor(depth - 1, num, node.get(requiredBit));
            } else {
                return xor(depth - 1, num, node.get(haveBit));
            }
        }
    }
}