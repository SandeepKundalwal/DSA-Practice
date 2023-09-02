import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String s = "tfgyrhhbzsdosifgyrihg";
        String dictionary[] = {"fgsj","fex","d","xktw","itam","tme","uowd","dos","lfqo","t","q","rrmy","fgyr","v","vmn","vw","rvo","e","i","si","dds","jy","hhbz","jguv","ihg","qjoz","zoal","zasb","m","xka","k","qfu","a","ons","hit"};
        System.out.println("Extra Characters: " + minExtraChar(s, dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(String word : dictionary){
            set.add(word);
        }

        int MEMO[] = new int[s.length()];
        Arrays.fill(MEMO, -1);

        return f(s.length() - 1, s, set, MEMO);
    }

    public static int f(int idx, String s, Set<String> set, int MEMO[]){
        if(idx < 0){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        // unused character
        int unusedCharacters = 1 + f(idx - 1, s, set, MEMO);

        int usedCharacters = Integer.MAX_VALUE;
        for(int i = idx; i >= 0; i--){
            // find the matching substring
            if(set.contains(s.substring(i, idx + 1))){
                usedCharacters = Math.min(usedCharacters, 0 + f(i - 1, s, set, MEMO));
            }
        }

        return MEMO[idx] = Math.min(usedCharacters, unusedCharacters);
    }
}