import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        int frequency[] = new int[202];
        for(int num : nums){
            frequency[num + 100]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.frequency == b.frequency){
                return b.value - a.value;
            }
            return a.frequency - b.frequency;
        });

        for(int i = 0; i < 202; i++){
            if(frequency[i] > 0){
                pq.offer(new Pair(i - 100, frequency[i]));
            }
        }

        int idx = 0;
        int sortedArray[] = new int[nums.length];
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            while(p.frequency > 0){
                sortedArray[idx++] = p.value;
                p.frequency--;
            }
        }

        return sortedArray;
    }

    static class Pair{
        int value;
        int frequency;

        public Pair(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }
}