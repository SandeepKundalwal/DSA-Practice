import java.util.Set;

class Trie{
    final TrieNode root;

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
        trieNode.setEnd();
    }

    public void findWord(int i, int j, StringBuilder sb, TrieNode trieNode, char board[][], boolean visited[][], Set<String> set){
        if(trieNode.getEnd()){
            set.add(sb.toString());
        }

        visited[i][j] = true;
        for(int direction[] : Main.directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if((dI >= 0 && dJ >= 0 && dI < board.length && dJ < board[0].length) && !visited[dI][dJ] && trieNode.contains(board[dI][dJ])){
                sb.append(board[dI][dJ]);
                findWord(dI, dJ, sb, trieNode.get(board[dI][dJ]), board, visited, set);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        visited[i][j] = false;
    }
}