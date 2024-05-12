import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int grid[][] = {
                {9,9,8,1},
                {5,6,2,6},
                {8,2,6,4},
                {6,2,2,2}
        };
        System.out.println(Arrays.deepToString(largestLocal(grid)));
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int answer[][] = new int[n - 2][n - 2];

        for(int i = 0; i < n - 2; i++){
            int threeCrossThree[] = new int[9];
            for(int j = 0; j < n - 2; j++){
                threeCrossThree[0] = grid[i][j];
                threeCrossThree[1] = grid[i][j + 1];
                threeCrossThree[2] = grid[i][j + 2];
                threeCrossThree[3] = grid[i + 1][j];
                threeCrossThree[4] = grid[i + 1][j + 1];
                threeCrossThree[5] = grid[i + 1][j + 2];
                threeCrossThree[6] = grid[i + 2][j];
                threeCrossThree[7] = grid[i + 2][j + 1];
                threeCrossThree[8] = grid[i + 2][j + 2];

                answer[i][j] = findMin(threeCrossThree);
            }
        }

        return answer;
    }

    public static int findMin(int threeCrossThree[]){
        int maxi = 0;
        for(int e : threeCrossThree){
            maxi = Math.max(maxi, e);
        }
        return maxi;
    }
}