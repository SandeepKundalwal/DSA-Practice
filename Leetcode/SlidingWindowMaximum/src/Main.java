import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int nums[] = {1,3,-1,-3,5,3,6,7};
        System.out.println("PriorityQueue: " + Arrays.toString(priorityQueue.maxSlidingWindow(nums, k)));
        System.out.println("HashSet: " + Arrays.toString(HashSet.maxSlidingWindow(nums, k)));
    }
}