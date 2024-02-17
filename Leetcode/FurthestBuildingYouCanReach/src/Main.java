import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int heights[] = {1,5,1,2,3,4,10000};
        int bricks = 4;
        int ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < heights.length; i++){
            if(heights[i - 1] < heights[i]){
                int hDiff = heights[i] - heights[i - 1];
                pq.offer(hDiff);
                if(pq.size() > ladders){
                    int bricksUsed = pq.remove();
                    if(bricks >= bricksUsed){
                        bricks -= bricksUsed;
                    } else {
                        return i - 1;
                    }
                }
            }
        }

        return heights.length - 1;
    }
}