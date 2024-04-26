import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int grid[][] = {
                {-8, 6, 5, 7}, {-3, 4, 4, 2}, {3, -1, 5, -6}, {5, 3, 6, 2}
        };
        System.out.println(minFallingPathSum(grid));
    }

    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int topThree[][] = new int[n][6];
        for(int i = 0; i < n; i++){
            topThree[i] = findTwoMinimum(grid[i]);
        }

        int MEMO[][] = new int[n][n];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        int first = topThree[0][0] + f(1, topThree[0][1], topThree, MEMO);
        int second = topThree[0][2] + f(1, topThree[0][3], topThree, MEMO);
        int third = topThree[0][4] + f(1, topThree[0][5], topThree, MEMO);

        return Math.min(first, Math.min(second, third));
    }

    public static int f(int i, int j, int topThree[][], int MEMO[][]){
        if(i >= MEMO.length){
            return 0;
        }

        if(j < 0){
            return 100001;
        }

        if(MEMO[i][j] != -1){
            return MEMO[i][j];
        }

        int mini = Integer.MAX_VALUE;
        if(j != topThree[i][1]){
            mini = Math.min(mini, topThree[i][0] + f(i + 1, topThree[i][1], topThree, MEMO));
        }

        if(j != topThree[i][3]) {
            mini = Math.min(mini, topThree[i][2] + f(i + 1, topThree[i][3], topThree, MEMO));
        }

        if(j != topThree[i][5]){
            mini = Math.min(mini, topThree[i][4] + f(i + 1, topThree[i][5], topThree, MEMO));
        }

        return MEMO[i][j] = mini;
    }

    public static int[] findTwoMinimum(int row[]){
        int firstMinIdx = -1;
        int secondMinIdx = -1;
        int thirdMinIdx = -1;
        int firstMin = 100001;
        int secondMin = 100001;
        int thirdMin = 100001;

        for(int i = 0; i < row.length; i++){
            if(row[i] < firstMin){
                firstMin = row[i];
                firstMinIdx = i;
            }
        }

        for(int i = 0; i < row.length; i++){
            if(row[i] < secondMin && i != firstMinIdx){
                secondMin = row[i];
                secondMinIdx = i;
            }
        }

        for(int i = 0; i < row.length; i++){
            if(row[i] < thirdMin && i != firstMinIdx && i != secondMinIdx){
                thirdMin = row[i];
                thirdMinIdx = i;
            }
        }

        // System.out.println(firstMin + ":" + firstMinIdx + "  " + secondMin + ":" + secondMinIdx);
        return new int[]{firstMin, firstMinIdx, secondMin, secondMinIdx, thirdMin, thirdMinIdx};
    }
}