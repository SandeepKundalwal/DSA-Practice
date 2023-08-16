import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class priorityQueue {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<IndexValue> pq = new PriorityQueue<>((a, b) -> (b.value - a.value));

        while(right < nums.length){
            pq.offer(new IndexValue(right, nums[right]));

            if((right - left + 1) == k){
                while(pq.peek().index < left){
                    pq.remove();
                }
                ans.add(pq.peek().value);
                left++;
            }
            right++;
        }

        int maxWindows[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            maxWindows[i] = ans.get(i);
        }

        return maxWindows;
    }
}
