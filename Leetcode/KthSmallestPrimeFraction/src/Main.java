import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        int answer[] = new int[2];

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Double.compare(b.fraction, a.fraction));

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                pq.offer(new Triplet(arr[i], arr[j], (double)arr[i] / arr[j]));
                if(pq.size() > k) pq.remove();
            }
        }

        answer[0] = pq.peek().arr_i;
        answer[1] = pq.peek().arr_j;

        return answer;
    }

    static class Triplet{
        int arr_i;
        int arr_j;
        double fraction;

        public Triplet(int arr_i, int arr_j, double fraction){
            this.arr_i = arr_i;
            this.arr_j = arr_j;
            this.fraction = fraction;
        }
    }
}