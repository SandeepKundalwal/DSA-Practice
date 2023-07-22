import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<StringBuilder> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            board.add(new StringBuilder(".".repeat(n)));
        }
        List<List<String>> chessBoard = new ArrayList<>();
        backtracking(0, n, board, chessBoard);
        return chessBoard;
    }

    public static void backtracking(int col, int n, List<StringBuilder> board, List<List<String>> chessBoard){
        if(col == n){
            List<String> currentBoard = new ArrayList<>();
            for(StringBuilder row : board){
                currentBoard.add(row.toString());
            }
            chessBoard.add(new ArrayList<>(currentBoard));
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(row, col, n, board)){
                board.get(row).setCharAt(col, 'Q');
                backtracking(col + 1, n, board, chessBoard);
                board.get(row).setCharAt(col, '.');
            }
        }
    }

    public static boolean isSafe(int row, int col, int n, List<StringBuilder> board){
        int originalRow = row;
        int originalCol = col;

        // checking upward diagonal
        while(row >= 0 && col >= 0){
            if(board.get(row).charAt(col) == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        // checking previous col
        row = originalRow;
        col = originalCol;
        while(col >= 0){
            if(board.get(row).charAt(col) == 'Q'){
                return false;
            }
            col--;
        }

        // checking downward diagonal
        row = originalRow;
        col = originalCol;
        while(row < n && col >= 0){
            if(board.get(row).charAt(col) == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
}