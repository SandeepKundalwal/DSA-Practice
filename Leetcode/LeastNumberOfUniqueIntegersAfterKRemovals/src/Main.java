import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int arr[] = {978196917,202623379,552387129,754071585,366121947,444381377,774799689,300436332,851324710,360072179};
        System.out.println(findLeastNumOfUniqueInts(arr, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int e : arr){
            hashMap.put(e, hashMap.getOrDefault(e, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.freq - b.freq));
        for(Map.Entry<Integer, Integer> it : hashMap.entrySet()){
            pq.offer(new Pair(it.getKey(), it.getValue()));
        }

        while(k > 0){
            int eFreq = pq.peek().freq;

            if(eFreq <= k){
                pq.remove();
                k -= eFreq;
            } else {
                break;
            }
        }

        return pq.size();
    }

    static class Pair{
        int e;
        int freq;

        public Pair(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }
}