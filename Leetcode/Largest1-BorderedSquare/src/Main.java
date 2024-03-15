public class Main {
    public static void main(String[] args) {
        int grid[][] = {
                {0,0,0,0,1},
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,1,1,1,1},
                {0,0,1,1,1}
        };
        System.out.println(largest1BorderedSquare(grid));
    }

    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Cell M[][] = new Cell[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                M[i][j] = new Cell();
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    if(i == 0 && j == 0){
                        M[i][j].ver = 1;
                        M[i][j].hori = 1;
                    } else if(i == 0){
                        M[i][j].ver = 1;
                        M[i][j].hori = M[i][j - 1].hori + 1;
                    } else if(j == 0){
                        M[i][j].ver = M[i - 1][j].ver + 1;
                        M[i][j].hori = 1;
                    } else {
                        M[i][j].ver = M[i - 1][j].ver + 1;
                        M[i][j].hori = M[i][j - 1].hori + 1;
                    }
                }
            }
        }

        int maxi = 0;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){

                if(M[i][j].ver == 0) continue;

                int mini = Math.min(M[i][j].ver, M[i][j].hori);

                for(int k = mini; k >= 1; k--){
                    if(M[i][j - k + 1].ver >= k && M[i - k + 1][j].hori >= k){
                        maxi = Math.max(maxi, k);
                        break;
                    }
                }
            }
        }

        return maxi * maxi;
    }

    static class Cell{
        int ver;
        int hori;

        public Cell(){
            this.ver = 0;
            this.hori = 0;
        }

        public Cell(int ver, int hori){
            this.ver = ver;
            this.hori = hori;
        }
    }
}