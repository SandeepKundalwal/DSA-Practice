import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int days = 10;
        int meetings[][] = {{5,7},{1,3},{9,10}};
        System.out.println(countDays(days, meetings));
    }

    public static int countDays(int days, int[][] meetings) {
        int n = meetings.length;

        Arrays.sort(meetings, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // incase 1st meeting doesnt start on day 1;
        int freeDays = meetings[0][0] - 1;
        int maxMeetingEnd = meetings[0][1];
        for(int i = 1; i < n; i++){
            int currMeetingStart = meetings[i][0];
            int currMeetingEnd = meetings[i][1];
            if(maxMeetingEnd < currMeetingStart){
                freeDays += (currMeetingStart - maxMeetingEnd) - 1;
            }

            maxMeetingEnd = Math.max(maxMeetingEnd, currMeetingEnd);
        }

        return freeDays + days - maxMeetingEnd;
    }
}