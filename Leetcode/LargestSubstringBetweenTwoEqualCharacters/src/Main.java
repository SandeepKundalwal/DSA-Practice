import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int longestSubstring = 0;
        int indexMap[] = new int[26];
        Arrays.fill(indexMap, -1);
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(indexMap[ch - 'a'] == -1){
                indexMap[ch - 'a'] = i;
            }
            longestSubstring = Math.max(longestSubstring, i - indexMap[ch - 'a']);
        }

        return longestSubstring - 1;
    }
}