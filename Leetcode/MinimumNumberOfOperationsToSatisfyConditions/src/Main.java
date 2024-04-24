import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int grid[][] = {
                {1,1,1},{0,0,0}
        };
        System.out.println(minimumOperations(grid));
    }

    public static int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int map[][] = new int[n][11];
        int MEMO[][] = new int[n][11];
        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], 0);
            Arrays.fill(MEMO[i], -1);
        }

        for(int col = 0; col < n; col++){
            for(int row = 0; row < m; row++){
                map[col][grid[row][col] + 1]++;
            }
        }

        return f(0, 0, m, n, map, MEMO);
    }

    public static int f(int col, int adjacentValue, int m, int n, int map[][], int MEMO[][]){
        if(col >= n){
            return 0;
        }

        if(MEMO[col][adjacentValue] != -1){
            return MEMO[col][adjacentValue];
        }

        int count = Integer.MAX_VALUE;
        for(int no = 1; no < 11; no++){
            if(no == adjacentValue){
                continue;
            }

            int difference = m - map[col][no];
            count = Math.min(count, difference + f(col + 1, no, m, n, map, MEMO));
        }

        return MEMO[col][adjacentValue] = count;
    }
}