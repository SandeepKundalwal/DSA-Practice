import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[][] directions = {
            {1, -1}, {1, 0}, {1, 1}
    };
    public static void main(String[] args) {
        int matrix[][] = {{-19,57},{-40,-5}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        Map<String, Integer> MEMO = new HashMap<>();
        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < matrix[0].length; j++){
            mini = Math.min(mini, matrix[0][j] + f(0, j, matrix, MEMO));
        }
        return mini;
    }

    public static int f(int i, int j, int matrix[][], Map<String, Integer> MEMO){
        if(i == matrix.length - 1){
            return 0;
        }

        String key = i + "|" + j;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        int pathSum = Integer.MAX_VALUE;
        for(int direction[] : directions){
            int dI = i + direction[0];
            int dJ = j + direction[1];

            if(dJ >= 0 && dJ < matrix[0].length){
                pathSum = Math.min(pathSum, matrix[dI][dJ] + f(dI, dJ, matrix, MEMO));
            }
        }

        MEMO.put(key, pathSum);
        return pathSum;
    }
}