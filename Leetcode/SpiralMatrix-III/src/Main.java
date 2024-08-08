import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int rows = 100;
        int cols = 100;
        int rStart = 99;
        int cStart = 99;
        System.out.println(Arrays.deepToString(spiralMatrixIII(rows, cols, rStart, cStart)));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int coordinates[][] = new int[rows * cols][2];

        int count = 0;
        int steps = 0;
        int currSteps = 0;
        int i = rStart, j = cStart, idx = 0;
        while(count < rows * cols){
            steps++;
            currSteps = 0;
            // move east (j++)
            while(currSteps < steps){
                if(i >= 0 && j >= 0 && i < rows && j < cols){
                    count++;
                    coordinates[idx++] = new int[]{i, j};
                }
                j++;
                currSteps++;
            }

            currSteps = 0;
            // moving south (i++)
            while(currSteps < steps){
                if(i >= 0 && j >= 0 && i < rows && j < cols){
                    count++;
                    coordinates[idx++] = new int[]{i, j};
                }
                i++;
                currSteps++;
            }

            steps++;
            currSteps = 0;
            // move west (j--)
            while(currSteps < steps){
                if(i >= 0 && j >= 0 && i < rows && j < cols){
                    count++;
                    coordinates[idx++] = new int[]{i, j};
                }
                j--;
                currSteps++;
            }

            currSteps = 0;
            // move north (i--)
            while(currSteps < steps){
                if(i >= 0 && j >= 0 && i < rows && j < cols){
                    count++;
                    coordinates[idx++] = new int[]{i, j};
                }
                i--;
                currSteps++;
            }
        }

        return coordinates;
    }
}