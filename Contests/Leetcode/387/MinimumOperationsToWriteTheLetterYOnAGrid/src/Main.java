import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int grid[][] = {{1,2,2},{1,1,0},{0,1,0}};
        System.out.println(minimumOperationsToWriteY(grid));
    }

    public static int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;

        Set<String> setY = new HashSet<>();

        // top left
        int i = 0, j = 0;
        while(i <= n/2 && j <= n/2){
            setY.add(i + "-" + j);
            i++;
            j++;
        }

        // top right
        i = 0;
        j = n - 1;
        while(i <= (n/2) && j >= n/2){
            setY.add(i + "-" + j);
            i++;
            j--;
        }

        // centre to bottom
        i = n/2;
        j = n/2;
        while(i < n){
            setY.add(i + "-" + j);
            i++;
        }

        int count = Integer.MAX_VALUE;
        for(int noI = 0; noI < 3; noI++){
            for(int noJ = 0; noJ < 3; noJ++){
                if(noI == noJ) continue;

                int currCount = 0;
                for(i = 0; i < n; i++){
                    for(j = 0; j < n; j++){
                        String pos = i + "-" + j;
                        if(setY.contains(pos)){
                            if(grid[i][j] != noI){
                                currCount++;
                            }
                        } else {
                            if(grid[i][j] != noJ){
                                currCount++;
                            }
                        }
                    }
                }
                count = Math.min(count, currCount);
            }
        }

        return count;
    }
}