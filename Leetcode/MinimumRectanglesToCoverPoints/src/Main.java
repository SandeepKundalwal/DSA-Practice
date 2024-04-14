import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int points[][] = {{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}};
         int w = 1;
        System.out.println(minRectanglesToCoverPoints(points, w));
    }

    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        int n = points.length;

        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int count = 0;
        for(int i = 0; i < n;){
            int end = i + 1;
            while(end < n && (points[end][0] - points[i][0] <= w)){
                end++;
            }
            i = end;
            count++;
        }
        return count;
    }
}