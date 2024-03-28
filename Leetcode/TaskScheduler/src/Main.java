import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        char tasks[] = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Alphabet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        int freq[] = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                pq.offer(new Alphabet((char)(i + 'A'), freq[i], 0));
            }
        }

        int time = 0;
        while(!pq.isEmpty()){
            if(pq.peek().time <= time){
                Alphabet alphabet = pq.remove();
                if(alphabet.freq > 1){
                    alphabet.freq = alphabet.freq - 1;
                    alphabet.time = alphabet.time + (n + 1);
                    pq.offer(alphabet);
                }
            }
            time++;
        }

        return time;
    }

    static class Alphabet{
        char c;
        int freq;
        int time;

        public Alphabet(char c, int freq, int time){
            this.c = c;
            this.freq = freq;
            this.time = time;
        }
    }
}