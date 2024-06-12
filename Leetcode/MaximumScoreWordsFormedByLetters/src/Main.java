public class Main {
    public static void main(String[] args) {
        String words[] = {"dog","cat","dad","good"};
        char letters[] = {'a','a','c','d','d','d','g','o','o'};
        int score[] = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words, letters, score));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for(char c : letters){
            freq[c - 'a']++;
        }

        return f(0, words, freq, score);
    }

    public static int f(int idx, String words[], int freq[], int score[]){
        if(idx >= words.length) return 0;

        int leave = 0 + f(idx + 1, words, freq, score);

        int tS = 0;
        boolean isPossible = true;
        int currFreq[] = new int[26];
        for(int i = 0; i < words[idx].length() && isPossible; i++){
            char c = words[idx].charAt(i);

            if(currFreq[c - 'a'] < freq[c - 'a']){
                currFreq[c - 'a']++;
                tS += score[c - 'a'];
            } else {
                isPossible = false;
            }
        }

        int take = 0;
        if(isPossible){
            for(int i = 0; i < 26; i++){
                freq[i] -= currFreq[i];
            }

            take = tS + f(idx + 1, words, freq, score);

            for(int i = 0; i < 26; i++){
                freq[i] += currFreq[i];
            }
        }

        return Math.max(leave, take);
    }
}