import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 3, 2, 1};
        int freq[] = {3,2,-3,1};
        System.out.println(Arrays.toString(mostFrequentIDs(nums, freq)));
    }

    public static long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;

        Map<Integer, Long> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(b.freq, a.freq));

        long ans[] = new long[n];
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], (long)freq[i]);
                pq.offer(new Pair(nums[i], freq[i]));
            } else {
                map.put(nums[i], map.get(nums[i]) + freq[i]);
                pq.offer(new Pair(nums[i], map.get(nums[i])));

                while(pq.peek().freq != map.get(pq.peek().num)){
                    pq.remove();
                }
            }
            ans[i] = pq.peek().freq;
        }

        return ans;
    }

    static class Pair{
        int num;
        long freq;

        public Pair(int num, long freq){
            this.num = num;
            this.freq = freq;
        }
    }
}