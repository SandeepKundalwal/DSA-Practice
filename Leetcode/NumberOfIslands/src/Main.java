public class Main {
    static int directions[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) {
        char grid[][] = {
                {'1', '1', '1', '1', '0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        int cntIslands = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    cntIslands++;
                    f(i, j, grid, visited, n, m);
                }
            }
        }
        return cntIslands;
    }

    public static void f(int i, int j, char grid[][], boolean visited[][], int n, int m){
        if(!insideBoundary(i, j, n, m)){
            return;
        }

        visited[i][j] = true;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(insideBoundary(dI, dJ, n, m) && grid[i][j] == '1' && !visited[dI][dJ]){
                f(dI, dJ, grid, visited, n, m);
            }
        }
    }

    public static boolean insideBoundary(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}