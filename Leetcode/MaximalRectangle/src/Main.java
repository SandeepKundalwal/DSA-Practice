import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        char matrix[][] = {{'0','1'},{'1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int hist[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    hist[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    if(matrix[i][j] == '0'){
                        hist[i][j] = 0;
                    } else {
                        hist[i][j] = hist[i - 1][j] + 1;
                    }
                }
            }
        }

        int maxi = 0;
        for(int i = 0; i < m; i++){
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            while(j < n){

                if(stack.isEmpty() || hist[i][j] >= hist[i][stack.peek()]){
                    stack.push(j);
                    j++;
                } else {
                    int curr = stack.pop();
                    int dist = (stack.isEmpty() ? j : j - stack.peek() - 1);
                    maxi = Math.max(maxi, hist[i][curr] * (dist == 0 ? 1 : dist));
                }
            }

            while(!stack.isEmpty()){
                int curr = stack.pop();
                int dist = (stack.isEmpty() ? j : j - stack.peek() - 1);
                maxi = Math.max(maxi, hist[i][curr] * (dist == 0 ? 1 : dist));
            }
        }

        return maxi;
    }
}