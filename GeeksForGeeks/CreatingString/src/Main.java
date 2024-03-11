import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        String s = "bbcdd";
        System.out.println(createString(n, k, s));
    }

    public static String createString(int n, int k, String s) {
        // code here
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        char prev = '$';
        int currConsecutive = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            List<Pair> res = findTopTwo(freq);
            if(prev != res.get(0).c){
                char curr = res.get(0).c;
                sb.append(curr);
                freq[curr - 'a']--;
                prev = curr;
                currConsecutive = 1;
            } else {
                if(currConsecutive + 1 <= k){
                    char curr = res.get(0).c;
                    sb.append(curr);
                    freq[curr - 'a']--;
                    prev = curr;
                    currConsecutive++;
                } else {
                    if(res.size() == 1){
                        break;
                    }

                    char currSec = res.get(1).c;
                    sb.append(currSec);
                    freq[currSec - 'a']--;
                    prev = currSec;
                    currConsecutive = 1;
                }
            }
        }
        return sb.toString();
    }

    public static List<Pair> findTopTwo(int freq[]){
        List<Pair> res = new ArrayList<>();
        for(int i = 25; i >= 0; i--){
            if(freq[i] != 0){
                res.add(new Pair((char)(i + 'a'), freq[i]));
            }

            if(res.size() == 2){
                break;
            }
        }
        return res;
    }

    static class Pair{
        char c;
        int freq;

        public Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
}