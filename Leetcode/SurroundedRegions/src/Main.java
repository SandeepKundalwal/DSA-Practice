import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        char board[][] = new char[m][n];
        for(int i = 0; i < m; i++){
            board[i] = in.next().toCharArray();
        }

        System.out.println(Arrays.deepToString(solve(board)));
    }

    /*
    "XXXX"
    "XOOX"
    "XXOX"
    "XOXX"
     */
    private static int directions[][] = {
            {-1, 0},{0, 1},{1,0},{0,-1}
    };
    private static char[][] solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(m == 1){
            return board;
        }

        boolean notPossibleToX[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O' && notPossibleToX[i][0] == false){
                doDFS(i, 0, m, n, board, notPossibleToX);
            }
        }

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O' && notPossibleToX[0][j] == false){
                doDFS(0, j, m, n, board, notPossibleToX);
            }
        }

        for(int i = 0; i < m; i++){
            if(board[i][n - 1] == 'O' && notPossibleToX[i][n - 1] == false){
                doDFS(i, n - 1, m, n, board, notPossibleToX);
            }
        }

        for(int j = 0; j < n; j++){
            if(board[m - 1][j] == 'O' && notPossibleToX[m - 1][j] == false){
                doDFS(m - 1, j, m, n, board, notPossibleToX);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && !notPossibleToX[i][j]){
                    board[i][j] = 'X';
                }
            }
        }


        return board;
    }

    private static void doDFS(int i, int j, int m, int n, char board[][], boolean notPossibleToX[][]){
        if(board[i][j] == 'X'){
            return;
        }

        if(notPossibleToX[i][j]){
            return;
        }

        notPossibleToX[i][j] = true;
        for(int direction[] : directions){
            int dX = i + direction[0];
            int dY = j + direction[1];

            if(dX >= 0 && dY >= 0 && dX < m && dY < n && board[dX][dY] == 'O'){
                doDFS(dX, dY, m, n, board, notPossibleToX);
            }
        }
    }
}