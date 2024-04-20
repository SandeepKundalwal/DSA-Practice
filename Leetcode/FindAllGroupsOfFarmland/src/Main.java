import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int land[][] = {{1,0,0},{0,1,1},{0,1,1}};
        System.out.println(Arrays.deepToString(findFarmland(land)));
    }

    public static int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        List<int[]> groups = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){
                    int endRow = i;
                    int endCol = j;

                    while(endRow < m && land[endRow][j] == 1){
                        endRow++;
                    }

                    while(endCol < n && land[i][endCol] == 1){
                        endCol++;
                    }

                    for(int k = i; k < endRow; k++){
                        for(int l = j; l < endCol; l++){
                            land[k][l] = 0;
                        }
                    }

                    groups.add(new int[]{i, j, endRow - 1, endCol - 1});
                }
            }
        }

        return groups.toArray(new int[groups.size()][]);
    }
}