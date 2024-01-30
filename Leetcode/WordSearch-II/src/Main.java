import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int directions[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) {
        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String words[] = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));
    }


    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        Set<String> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i][j];
                TrieNode trieNode = trie.root;
                if(trieNode.contains(c)){
                    trieNode = trieNode.get(c);
                    StringBuilder sb = new StringBuilder();
                    trie.findWord(i, j, sb.append(c), trieNode, board, new boolean[m][n], set);
                }
            }
        }
        return new ArrayList<>(set);
    }
}