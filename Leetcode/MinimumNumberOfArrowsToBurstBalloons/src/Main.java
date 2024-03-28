import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int points[][] = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int arrows = 0;
        for(int i = 0; i < points.length;){
            int shootCoordinate = points[i][1];

            int j = i + 1;
            while(j < points.length && points[j][0] <= shootCoordinate && points[j][1] >= shootCoordinate){
                j++;
            }
            i = j;
            arrows++;
        }

        return arrows;
    }
}