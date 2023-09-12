public class Main {
    public static void main(String[] args) {
        String s = "aabbbcc";
        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s) {
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int freqChar[] = new int[s.length() + 1];
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                freqChar[freq[i]]++;
            }
        }

        int cnt = 0;
        for(int i = freqChar.length - 1; i > 0; i--){
            if(freqChar[i] > 1){
                cnt += (freqChar[i] - 1);
                freqChar[i - 1] += (freqChar[i] - 1);
            }
        }

        return cnt;
    }
}