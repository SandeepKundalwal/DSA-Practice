public class Main {
    static int directions[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) {
        char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && foundWord(i, j, 1, board, word)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean foundWord(int i, int j, int idx, char[][] board, String word){
        if(idx == word.length()){
            return true;
        }

        char c = board[i][j];
        board[i][j] = ' ';

        boolean ans = false;

        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(insideBoard(dI, dJ, board) && board[dI][dJ] != ' ' && board[dI][dJ] == word.charAt(idx)){
                ans |= foundWord(dI, dJ, idx + 1, board, word);
            }
        }

        board[i][j] = c;
        return ans;
    }

    public static boolean insideBoard(int i, int j, char[][] board){
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}