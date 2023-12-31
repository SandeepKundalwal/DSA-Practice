import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int board[][] = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    /**
     1. Any live cell with fewer than two live neighbours dies as if caused by under-population
     2. Any live cell with two or three live neighbours lives on to the next generation
     3. Any live cell with more than three live neighoburs dies, as ig by over popoulation
     4. Any dead cell with exactly three live neigbours becomes a live cell, as if by reproduction
     */

    // I just need current & previous row to simulate this.
    static int directions[][] = {
            {-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}
    };
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int previousRow[] = new int[n];
        int currentRow[] = new int[n];

        for(int i = 0; i < m; i++){
            int temp[] = board[i].clone();
            for(int j = 0; j < n; j++){
                int liveCell = 0;
                int deadCell = 0;
                currentRow[j] = board[i][j];
                for(int direction[] : directions){
                    int dI = i + direction[0];
                    int dJ = j + direction[1];

                    if(isValid(dI, dJ, m, n)){
                        if(dI < i){
                            if(previousRow[dJ] == 0){
                                deadCell++;
                            } else {
                                liveCell++;
                            }
                        } else if(dI == i && dJ < j){
                            if(currentRow[dJ] == 0){
                                deadCell++;
                            } else {
                                liveCell++;
                            }
                        } else {
                            if(board[dI][dJ] == 0){
                                deadCell++;
                            } else {
                                liveCell++;
                            }
                        }
                    }
                }

                if(board[i][j] == 0){
                    if(liveCell == 3){
                        board[i][j] = 1;
                    }
                } else {
                    if(liveCell < 2){
                        board[i][j] = 0;
                    } else if(liveCell == 2 || liveCell == 3){
                        board[i][j] = 1;
                    } else{
                        board[i][j] = 0;
                    }
                }
            }
            previousRow = temp.clone();
        }
    }

    public static boolean isValid(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}