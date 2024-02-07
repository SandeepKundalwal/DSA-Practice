import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for(char c : s.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Frequency> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(Map.Entry<Character, Integer> it : hashMap.entrySet()){
            pq.offer(new Frequency(it.getKey(), it.getValue()));
        }

        StringBuilder sortedString = new StringBuilder();
        while(!pq.isEmpty()){
            Frequency fq = pq.remove();
            sortedString.append(Character.toString(fq.c).repeat(fq.freq));
        }

        return sortedString.toString();
    }

    static class Frequency{
        char c;
        int freq;

        public Frequency(){}

        public Frequency(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
}