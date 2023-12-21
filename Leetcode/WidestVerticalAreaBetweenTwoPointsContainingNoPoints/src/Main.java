import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int points[][] = {{8,7},{9,9},{7,4},{9,7}};
        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int maxWidth = 0;
        for(int point = 1; point < points.length; point++){
            maxWidth = Math.max(maxWidth, points[point][0] - points[point - 1][0]);
        }

        return maxWidth;
    }
}