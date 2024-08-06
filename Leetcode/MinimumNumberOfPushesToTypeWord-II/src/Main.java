import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(minimumPushes(word));
    }

    public static int minimumPushes(String word) {
        int freq[] = new int[26];
        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int times = 0;
        int count = 0;
        int pushes = 0;
        for(int i = 25; i >= 0 && freq[i] > 0; i--){
            if(count % 8 == 0){
                times++;
            }

            pushes += (times * freq[i]);
            count++;
        }

        return pushes;
    }
}