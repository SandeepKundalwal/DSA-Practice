import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int target = 0;
        int matrix[][] = {
                {1,-1},{-1,1}
        };
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int prefixSumRow[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                prefixSumRow[i][j] = matrix[i][j] + (j == 0 ? 0 : prefixSumRow[i][j - 1]);
            }
        }

        int count = 0;
        for(int colStart = 0; colStart < n; colStart++){
            for(int colEnd = colStart; colEnd < n; colEnd++){
                int currSum = 0;
                Map<Integer, Integer> prefixCol = new HashMap<>();
                prefixCol.put(0, 1);

                for(int row = 0; row < m; row++){
                    currSum += prefixSumRow[row][colEnd] - (colStart != 0 ? prefixSumRow[row][colStart - 1] : 0);
                    int remove = currSum - target;
                    if(prefixCol.containsKey(remove)){
                        count += prefixCol.get(remove);
                    }

                    prefixCol.put(currSum, prefixCol.getOrDefault(currSum, 0) + 1);
                }
            }
        }
        return count;
    }
}