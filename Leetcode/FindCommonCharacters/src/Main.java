import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String words[] = {"cool","lock","cook"};
        System.out.println(commonChars(words));
    }

    // O(1) Memory
    public static List<String> commonChars(String[] words) {
        int n = words.length;

        int commonChars[] = new int[26];
        int currentChars[] = new int[26];

        for(char c : words[0].toCharArray()){
            commonChars[c - 'a']++;
        }

        for(int i = 1; i < n; i++){
            Arrays.fill(currentChars, 0);

            for(char c : words[i].toCharArray()){
                currentChars[c - 'a']++;
            }

            for(int j = 0; j < 26; j++){
                commonChars[j] = Math.min(commonChars[j], currentChars[j]);
            }
        }

        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < commonChars[i]; j++){
                answer.add(Character.toString((char)(i + 'a')));
            }
        }

        return answer;
    }

    // O(n) Memory
    public List<String> commonCharsExtraMemory(String[] words) {
        int n = words.length;

        char wordCharFrequency[][] = new char[n][26];
        for(int i = 0; i < n; i++){
            String word = words[i];
            for(char c : word.toCharArray()){
                wordCharFrequency[i][c - 'a']++;
            }
        }

        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            int minFrequency = Integer.MAX_VALUE;
            for(int k = 0; k < n; k++){
                if(wordCharFrequency[k][i] == 0){
                    minFrequency = 0;
                    break;
                }
                minFrequency = Math.min(minFrequency, wordCharFrequency[k][i]);
            }

            for(int j = 0; j < minFrequency; j++){
                answer.add(Character.toString((char)(i + 'a')));
            }
        }

        return answer;
    }
}