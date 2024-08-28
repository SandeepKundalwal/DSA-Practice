public class Main {
    static boolean result;
    static int directions[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) {
        int grid1[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 0}};
        int grid2[][] = {{0, 1, 1}, {0, 1, 1}, {0, 0, 0}};
        System.out.println(countSubIslands(grid1, grid2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1){
                    result = true;
                    if(grid1[i][j] == 1){
                        f(i, j, m, n, grid1, grid2);
                        if(result){
                            count++;
                        }
                    } else {
                        f(i, j, m, n, grid1, grid2);
                    }
                }
            }
        }

        return count;
    }

    public static void f(int i, int j, int m, int n, int grid1[][], int grid2[][]){
        grid2[i][j] = 0;

        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(isValidCell(dI, dJ, m, n) && grid2[dI][dJ] == 1){
                if(grid1[dI][dJ] != 1){
                    result = false;
                }

                f(dI, dJ, m, n, grid1, grid2);
            }
        }
    }

    public static boolean isValidCell(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}