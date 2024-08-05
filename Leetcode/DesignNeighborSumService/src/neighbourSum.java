import java.util.HashMap;
import java.util.Map;

class neighborSum {
    int n;
    int grid[][];
    Map<Integer, int[]> hashMap;
    public neighborSum(int[][] grid) {
        this.n = grid.length;
        this.grid = new int[n][n];
        this.hashMap = new HashMap<>();

        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.n; j++){
                this.grid[i][j] = grid[i][j];
                hashMap.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int coordinates[] = this.hashMap.get(value);
        int i = coordinates[0];
        int j = coordinates[1];

        int val = 0;
        if(i > 0) val += this.grid[i - 1][j];
        if(i < this.n - 1) val += this.grid[i + 1][j];
        if(j > 0) val += this.grid[i][j - 1];
        if(j < this.n - 1) val += this.grid[i][j + 1];
        return val;
    }

    public int diagonalSum(int value) {
        int coordinates[] = this.hashMap.get(value);
        int i = coordinates[0];
        int j = coordinates[1];

        int val = 0;
        if(i > 0 && j > 0) val += this.grid[i - 1][j - 1];
        if(i < this.n - 1 && j < this.n - 1) val += this.grid[i + 1][j + 1];
        if(i > 0 && j < this.n - 1) val += this.grid[i - 1][j + 1];
        if(i < this.n - 1 && j > 0) val += this.grid[i + 1][j - 1];
        return val;
    }
}