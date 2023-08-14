public class Main {
    public static void main(String[] args) {
        int k = 2;
        int nums[] = {3,2,1,5,6,4};
        System.out.println("Priority Queue: " + priorityQueue.findKthLargest(nums, k));
        System.out.println("Priority Queue: " + QuickSelect.findKthLargest(nums, k));
    }
}