import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String s = "a?df?ed?dfr?wsa?fvfefdswmklp???";
        System.out.println(minimizeStringValue(s));
    }

    public static String minimizeStringValue(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.freq == b.freq){
                return a.ch - b.ch;
            }

            return a.freq - b.freq;
        });

        int charMap[] = new int[26];
        for(char c : s.toCharArray()){
            if(c == '?'){
                continue;
            }
            charMap[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(charMap[i] > 0){
                pq.offer(new Pair((char)(i + 'a'), charMap[i]));
            }
        }

        int charsToInclude[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '?'){
                boolean minCostCharFound = false;
                for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
                    if(charMap[ch - 'a'] == 0){
                        charMap[ch - 'a']++;
                        charsToInclude[ch - 'a']++;
                        pq.offer(new Pair(ch, 1));
                        minCostCharFound = true;
                        break;
                    }
                }

                if(!minCostCharFound){
                    Pair pair = pq.remove();
                    charMap[pair.ch - 'a']++;
                    charsToInclude[pair.ch - 'a']++;
                    pq.offer(new Pair(pair.ch, pair.freq + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '?'){
                for(int j = 0; j < 26; j++){
                    if(charsToInclude[j] > 0){
                        sb.append((char)(j + 'a'));
                        charsToInclude[j]--;
                        break;
                    }
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    static class Pair{
        char ch;
        int freq;

        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}