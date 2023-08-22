public class Main {
    public static void main(String[] args) {
        char board[][] = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Is it valid? " + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!check(i, j, board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean check(int i, int j, char board[][]){
        //perform vertically
        int digit = (int)board[i][j];
        for(int k = 0; k < 9; k++){
            if(k != i && (int)board[k][j] == digit){
                return false;
            }
        }

        //perform horizontal;
        for(int k = 0; k < 9; k++){
            if(k != j && (int)board[i][k] == digit){
                return false;
            }
        }

        //perform check in sub-boxes
        // how do i make sure it checks the sub-box only and not anything else.?
        int iStart = ((i / 3 == 0) ? 0 : (i / 3 == 1) ? 3 : 6);
        int jStart = ((j / 3 == 0) ? 0 : (j / 3 == 1) ? 3 : 6);
        int iLimit = ((i / 3 == 0) ? 3 : (i / 3 == 1) ? 6 : 9);
        int jLimit = ((j / 3 == 0) ? 3 : (j / 3 == 1) ? 6 : 9);
        for(int k = iStart; k < iLimit; k++){
            for(int l = jStart; l < jLimit; l++){
                if(k != i && l != j && (int)board[k][l] == digit){
                    return false;
                }
            }
        }
        return true;
    }
}