import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int meetings[][] = {
                {1,20},{2,10},{3,5},{4,9},{6,8}
        };
        System.out.println(mostBooked(n, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            unusedRooms.offer(i);
        }

        int meetingRoom[] = new int[n];
        PriorityQueue<Pair> usedRooms = new PriorityQueue<>((a, b) ->
                (a.endTime == b.endTime ? a.roomNo - b.roomNo : Long.compare(a.endTime, b.endTime)));

        for(int meeting[] : meetings){
            long sTime = meeting[0];
            long eTime = meeting[1];

            while(!usedRooms.isEmpty() && usedRooms.peek().endTime <= sTime){
                int room = usedRooms.remove().roomNo;
                unusedRooms.offer(room);
            }

            if(!unusedRooms.isEmpty()){
                int room = unusedRooms.remove();
                meetingRoom[room]++;
                usedRooms.offer(new Pair(room, eTime));
            } else {
                Pair completionTime = usedRooms.remove();
                meetingRoom[completionTime.roomNo]++;
                usedRooms.offer(new Pair(completionTime.roomNo, completionTime.endTime + (eTime - sTime)));
            }
        }

        int MaxMeetingCount = 0, maxMeetingCountRoom = 0;
        for(int i = 0; i < n; i++){
            if(meetingRoom[i] > MaxMeetingCount){
                MaxMeetingCount = meetingRoom[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }

    public static class Pair{
        int roomNo;
        long endTime;

        public Pair(int roomNo, long endTime){
            this.roomNo = roomNo;
            this.endTime = endTime;
        }
    }
}