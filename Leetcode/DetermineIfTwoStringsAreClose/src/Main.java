import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word1 = "uau";
        String word2 = "ssx";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        return isPossible(word1, word2);
    }

    public static boolean isPossible(String word1, String word2){
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i = 0; i < word1.length(); i++){
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        // if different character in any string
        for(int i = 0; i < 26; i++){
            if((freq1[i] == 0 && freq2[i] != 0) ||  freq1[i] != 0 && freq2[i] == 0){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 25; i >= 0; i--){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}