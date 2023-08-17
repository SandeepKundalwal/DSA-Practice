import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int courses[][] = {
                {100,200},{200,1300},{1000,1250},{2000,3200}
        };
        System.out.println("Number of courses that can be taken: " + scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (i1, i2) -> i1[1] - i2[1]);

        int n = courses.length;
        int AHEAD[] = new int[courses[n - 1][1] + 1];
        int CURR[] = new int[courses[n - 1][1] + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int daysTaken = courses[n - 1][1]; daysTaken >= 0; daysTaken--) {
                int dontTake = 0 + AHEAD[daysTaken];

                int take = Integer.MIN_VALUE;
                if (daysTaken + courses[idx][0] <= courses[idx][1]) {
                    take = 1 + AHEAD[daysTaken + courses[idx][0]];
                }
                CURR[daysTaken] = Math.max(dontTake, take);
            }
            System.arraycopy(CURR, 0, AHEAD, 0, courses[n - 1][1] + 1);
        }
        return AHEAD[0];
    }
}