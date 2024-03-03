public class Main {
    public static void main(String[] args) {
        int grid[][] = {{7,2,9},{1,5,0},{2,6,6}};
        int k = 20;
        System.out.println(countSubmatrices(grid, k));
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int sum[][] = new int[m][n];
        sum[0] = grid[0];
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                sum[i][j] = sum[i - 1][j] + grid[i][j];
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            int rowSum = 0;
            for(int j = 0; j < n; j++){
                rowSum += sum[i][j];
                if(rowSum <= k){
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}