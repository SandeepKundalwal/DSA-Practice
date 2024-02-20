import java.util.Map;

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

    public boolean fTrie(int idx, TrieNode trieNode, String A, Map<Integer, Boolean> MEMO){
        if(idx >= A.length()){
            return true;
        }

        if(MEMO.containsKey(idx)){
            return MEMO.get(idx);
        }

        boolean ans = false;
        for(int i = idx; i < A.length(); i++){
            char c = A.charAt(i);
            if(trieNode.contains(c)){
                trieNode = trieNode.get(c);
                if(trieNode.isEnd){
                    if(fTrie(i + 1, root, A, MEMO)){
                        ans = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }

        MEMO.put(idx, ans);
        return ans;
    }
}