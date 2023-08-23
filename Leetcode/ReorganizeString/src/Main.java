import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }

    public static String reorganizeString(String s) {
        if(s.length() == 1){
            return s;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.frequency - a.frequency));

        int frequency[] = new int[26];
        for(char character : s.toCharArray()){
            frequency[character - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(frequency[i] > 0){
                pq.offer(new Pair((char)(i + 'a'), frequency[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first = pq.remove();
            Pair second = pq.isEmpty() ? null : pq.remove();

            if(first.frequency > 0){
                sb.append(first.character);
                pq.offer(new Pair(first.character, --first.frequency));
            }

            if(second != null && second.frequency > 0){
                sb.append(second.character);
                pq.offer(new Pair(second.character, --second.frequency));
            }
        }

        for(int i = 0; i < sb.length() - 1; i++){
            if(sb.charAt(i) == sb.charAt(i + 1)){
                return new String();
            }
        }

        return sb.toString();
    }
}