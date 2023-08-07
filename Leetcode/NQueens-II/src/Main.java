public class Main {
    public static void main(String[] args) {
        int n = 9;
        System.out.println("Number of Boards Possible: " + totalNQueens(n));
    }
    public static int totalNQueens(int n) {
        if(n == 1){
            return 1;
        }

        char board[][] = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        return backtrack(0, n, board);
    }


    public static int backtrack(int col, int n, char board[][]){
        if(col == n){
            return 1;
        }

        int cnt = 0;
        for(int row = 0; row < n; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                cnt += backtrack(col + 1, n, board);
                board[row][col] = '.';
            }
        }
        return cnt;
    }

    public static boolean isSafe(int i, int j, char board[][]){
        int originalI = i;
        int originalJ = j;
        //check upward diagonal
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        i = originalI;
        j = originalJ;
        // check downward diagonal
        while(i < board.length && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }

        i = originalI;
        j = originalJ;
        // check backrow
        while(j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            j--;
        }

        return true;
    }
}