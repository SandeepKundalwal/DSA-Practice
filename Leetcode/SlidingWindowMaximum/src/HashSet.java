import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;

public class HashSet {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k > nums.length) return new int[0];

        PriorityQueue<IndexValue> queue = new PriorityQueue<>((a, b) -> (b.value - a.value));
        Set<Integer> removedSet = new java.util.HashSet<>();

        int windowSize = 1, left = 0, right = 0, maxEveryWindow = Integer.MIN_VALUE, arrayIndexer = 0;
        while(right < nums.length){
            queue.add(new IndexValue(right, nums[right]));
            if(windowSize == k && left <= right){
                while(removedSet.contains(queue.peek().index)){
                    queue.remove();
                }
                nums[arrayIndexer++] = queue.peek().value;
                removedSet.add(left++);
                windowSize--;
            }
            windowSize++;
            right++;
        }
        return Arrays.copyOfRange(nums, 0, arrayIndexer);
    }
}
