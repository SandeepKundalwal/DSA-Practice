public class Main {
    public static void main(String[] args) {
        int grid[][] = {{1,0,0},{0,0,0},{0,0,1}};
        System.out.println(minFlips(grid));
    }

    public static int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int countRowChanges = 0;
        for(int i = 0; i < m; i++){
            int left = 0, right = n - 1;
            while(left < right){
                if(grid[i][left++] != grid[i][right--]){
                    countRowChanges++;
                }
            }
        }

        int countColChanges = 0;
        for(int j = 0; j < n; j++){
            int left = 0, right = m - 1;
            while(left < right){
                if(grid[left++][j] != grid[right--][j]){
                    countColChanges++;
                }
            }
        }

        return Math.min(countRowChanges, countColChanges);
    }
}