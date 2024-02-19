import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        String s = "abccc";
        System.out.println(minValue(s, k));
    }

    static int minValue(String s, int k){
        // code here
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                pq.offer(freq[i]);
            }
        }

        while(!pq.isEmpty() && k > 0){
            int max = pq.remove();
            max--;
            k--;

            if(max > 0){
                pq.offer(max);
            }
        }

        int value = 0;
        while(!pq.isEmpty()){
            int e = pq.remove();
            value += (e*e);
        }

        return value;
    }
}