import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,2,2,2,4,4,2,2};
        int limit = 0;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.val - a.val;
        });

        int maxi = 0;
        int left = 0, right = 0;
        while(right < n){
            minHeap.offer(new Pair(right, nums[right]));
            maxHeap.offer(new Pair(right, nums[right]));

            while(maxHeap.peek().val - minHeap.peek().val > limit){
                if(minHeap.peek().idx < maxHeap.peek().idx){
                    while(left < right && left <= minHeap.peek().idx){
                        left++;
                    }
                    minHeap.remove();
                } else {
                    while(left < right && left <= maxHeap.peek().idx){
                        left++;
                    }
                    maxHeap.remove();
                }
            }

            maxi = Math.max(maxi, right - left + 1);
            right++;
        }

        return maxi;
    }

    static class Pair{
        int idx;
        int val;

        public Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}