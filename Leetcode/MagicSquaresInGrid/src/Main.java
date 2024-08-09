import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int grid[][] = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for(int i = 0; i <= rows - 3; i++){
            for(int j = 0; j <= cols - 3; j++){
                Set<Integer> digits = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

                int neededSum = -1;
                boolean isMagicSquare = true;
                for(int k = i; k < i + 3; k++){
                    int rowSum = 0;
                    for(int l = j; l < j + 3; l++){
                        rowSum += grid[k][l];
                        digits.remove(grid[k][l]);
                    }

                    if(neededSum == -1 || neededSum == rowSum){
                        neededSum = rowSum;
                        continue;
                    } else {
                        isMagicSquare = false;
                        break;
                    }
                }

                if(!isMagicSquare || digits.size() != 0){
                    continue;
                }


                for(int k = j; k < j + 3; k++){
                    int colSum = 0;
                    for(int l = i; l < i + 3; l++){
                        colSum += grid[l][k];
                    }

                    if(neededSum != colSum){
                        isMagicSquare = false;
                        break;
                    }
                }

                if(!isMagicSquare){
                    continue;
                }

                int k = i, l = j;
                int frontDiagonal = 0;
                while(k < i + 3 && l < j + 3){
                    frontDiagonal += grid[k++][l++];
                }

                if(frontDiagonal != neededSum){
                    continue;
                }

                k = i;
                l = j + 2;
                int backDiagonal = 0;
                while(k < i + 3 && l >= j - 3){
                    backDiagonal += grid[k++][l--];
                }

                if(backDiagonal != neededSum){
                    continue;
                }

                count++;
            }
        }

        return count;
    }
}