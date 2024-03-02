import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int k = 10;
        int nums[] = {2,11,10,1,3};
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.offer((long) nums[i]);
        }

        int count = 0;
        while(pq.size() > 1){
            long x = pq.remove();
            long y = pq.remove();

            if(x >= k && y >= k){
                break;
            } else {
                count++;
                long newNo = Math.min(x, y) * 2 + Math.max(x, y);
                pq.offer(newNo);
            }
        }

        return count;
    }
}