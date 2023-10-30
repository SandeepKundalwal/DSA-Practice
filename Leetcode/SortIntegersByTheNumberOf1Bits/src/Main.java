import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    static class Pair {
        int value;
        int frequency;

        public Pair(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }

    public static  int[] sortByBits(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.frequency == b.frequency) {
                    return a.value - b.value;
                } else {
                    return a.frequency - b.frequency;
                }
            }
        });

        for(int num : arr){
            int frequency = countBits(num);
            pq.add(new Pair(num, frequency));
        }

        int idx = 0;
        int res[] = new int[arr.length];
        while(!pq.isEmpty()){
            res[idx++] = pq.remove().value;
        }
        return res;
    }

    public static int countBits(int num){
        int cnt = 0;
        for(int bit = 0; bit < 32; bit++){
            if((num & (1 << bit)) != 0){
                cnt++;
            }
        }
        return cnt;
    }

}