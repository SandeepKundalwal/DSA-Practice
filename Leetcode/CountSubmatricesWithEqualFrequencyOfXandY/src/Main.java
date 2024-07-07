public class Main {
    public static void main(String[] args) {
        char grid[][] = {
                {'Y', '.'},{'X','.'}
        };
        System.out.println(numberOfSubmatrices(grid));
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Pair G[][] = new Pair[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                G[i][j] = new Pair(0, 0);
                if(j == 0){
                    if(grid[i][j] == 'X'){
                        G[i][j].X = 1;
                    } else if(grid[i][j] == 'Y'){
                        G[i][j].Y = 1;
                    }
                } else {
                    if(grid[i][j] == 'X'){
                        G[i][j].X = 1 + G[i][j - 1].X;
                        G[i][j].Y = G[i][j - 1].Y;
                    } else if(grid[i][j] == 'Y'){
                        G[i][j].X = G[i][j - 1].X;
                        G[i][j].Y = 1 + G[i][j - 1].Y;
                    } else {
                        G[i][j].X = G[i][j - 1].X;
                        G[i][j].Y = G[i][j - 1].Y;
                    }
                }
            }
        }

        for(int j = 0; j < n; j++){
            for(int i = 1; i < m; i++){
                G[i][j].X += G[i - 1][j].X;
                G[i][j].Y += G[i - 1][j].Y;
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(G[i][j].X > 0 && G[i][j].X == G[i][j].Y){
                    count++;
                }
            }
        }

        return count;
    }

    static class Pair{
        int X;
        int Y;

        public Pair(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
    }
}