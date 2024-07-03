public class Main {
    public static void main(String[] args) {
        int grid[][] = {{0,1,0},{1,0,1}};
        System.out.println(minimumArea(grid));
    }

    public static int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int top = 0;
        outer: for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    top = i;
                    break outer;
                }
            }
        }

        int bottom = 0;
        outer: for(int i = m - 1; i >= top; i--){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    bottom = i;
                    break outer;
                }
            }
        }

        int left = 0;
        outer: for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1){
                    left = j;
                    break outer;
                }
            }
        }

        int right = 0;
        outer: for(int j = n - 1; j >= left; j--){
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1){
                    right = j;
                    break outer;
                }
            }
        }

        return (bottom - top + 1) * (right - left + 1);
    }
}