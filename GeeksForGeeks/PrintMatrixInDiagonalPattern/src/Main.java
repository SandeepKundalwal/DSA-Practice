import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(matrixDiagonally(mat)));
    }

    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int ans[] = new int[n * n];

        int idx = 0;
        boolean down = false;

        for(int top = 0; top < n; top++){
            int i = down ? 0 : top;
            int j = down ? top : 0;

            if(down){
                while(i < n && j >= 0){
                    ans[idx++] = mat[i][j];
                    i++;
                    j--;
                }
            } else {
                while(i >= 0 && j < n){
                    ans[idx++] = mat[i][j];
                    i--;
                    j++;
                }
            }
            down = !down;
        }

        for(int bottom = 1; bottom < n; bottom++){
            int i = down ? bottom : n - 1;
            int j = down ? n - 1 : bottom;

            if(down){
                while(i < n && j >= 0){
                    ans[idx++] = mat[i][j];
                    i++;
                    j--;
                }
            } else {
                while(i >= 0 && j < n){
                    ans[idx++] = mat[i][j];
                    i--;
                    j++;
                }
            }
            down = !down;
        }
        return ans;

    }
}