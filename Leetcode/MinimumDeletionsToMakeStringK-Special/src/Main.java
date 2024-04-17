import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word = "vnnppvvbbn";
        int k = 0;
        System.out.println(minimumDeletions(word, k));
    }

    public static int minimumDeletions(String word, int k) {
        int freq[] = new int[26];
        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int start = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                break;
            }
            start++;
        }

        int MEMO[][] = new int[26][26];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        return f(start, 25, freq, k, MEMO);
    }

    public static int f(int start, int end, int freq[], int k, int MEMO[][]){
        if(start >= end || freq[end] - freq[start] <= k) {
            return 0;
        }

        if(MEMO[start][end] != -1){
            return MEMO[start][end];
        }

        int left = freq[start] + f(start + 1, end, freq, k, MEMO);
        int right = (freq[end] - freq[start] - k) + f(start, end - 1, freq, k, MEMO);

        return MEMO[start][end] = Math.min(left, right);
    }
}