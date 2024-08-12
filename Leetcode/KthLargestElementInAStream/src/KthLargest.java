import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> topK;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.topK = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            if(topK.size() < this.k){
                topK.offer(nums[i]);
            } else {
                if(nums[i] > this.topK.peek()){
                    this.topK.remove();
                    this.topK.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if(this.topK.size() < this.k){
            this.topK.offer(val);
        } else if(val > this.topK.peek()) {
            this.topK.remove();
            this.topK.offer(val);
        }

        return this.topK.peek();
    }
}