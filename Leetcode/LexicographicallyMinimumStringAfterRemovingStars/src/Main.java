import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "aaba*";
        System.out.println(clearStars(s));
    }

    public static String clearStars(String s) {
        int n = s.length();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.c == b.c){
                return b.idx - a.idx;
            }

            return a.c - b.c;
        });

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '*'){
                pq.remove();
            } else {
                pq.offer(new Pair(c, i));
            }
        }

        char availableChars[] = new char[n];
        Arrays.fill(availableChars, '$');
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            availableChars[p.idx] = p.c;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : availableChars){
            if(c != '$'){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    static class Pair{
        char c;
        int idx;

        public Pair(char c, int idx){
            this.c = c;
            this.idx = idx;
        }
    }
}