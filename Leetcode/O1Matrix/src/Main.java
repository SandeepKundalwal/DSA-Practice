import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int directions[][] = new int[][]{
            {-1,0}, {0,1},{1,0},{0,-1}
    };

    public static void main(String[] args) {
        int mat[][] = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int i = queue.peek().i;
                int j = queue.peek().j;
                queue.remove();

                for(int direction[] : directions){
                    int dI = i + direction[0];
                    int dJ = j + direction[1];

                    if(isValid(dI, dJ, m, n) && !visited[dI][dJ]){
                        mat[dI][dJ] = distance;
                        queue.offer(new Pair(dI, dJ));
                        visited[dI][dJ] = true;
                    }
                }
            }
            distance++;
        }

        return mat;
    }

    public static boolean isValid(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}