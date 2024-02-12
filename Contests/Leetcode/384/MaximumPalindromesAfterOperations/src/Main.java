import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String words[] = {"aagha","bc"};
        System.out.println(maxPalindromesAfterOperations(words));
    }

    public static int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;

        int frequency[] = new int[26];
        int wordsLength[] = new int[n];
        for(int i = 0; i < n; i++){
            for(char c : words[i].toCharArray()){
                frequency[c - 'a']++;
            }
            wordsLength[i] = words[i].length();
        }

        Arrays.sort(wordsLength);

        int evenPair = 0, oddChars = 0;

        for(int i = 0; i < 26; i++){
            if(frequency[i] % 2 == 1){
                oddChars++;

            }
            evenPair += (frequency[i] / 2);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            int wLen = wordsLength[i];
            if(wLen % 2 == 1){
                if(oddChars <= 0){
                    evenPair--;
                    oddChars++;
                }
            }

            if(evenPair < (wLen / 2)) break;
            evenPair -= (wLen / 2);
            count++;
        }

        return count;
    }
}