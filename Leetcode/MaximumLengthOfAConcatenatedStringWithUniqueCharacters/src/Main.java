import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList("un","iq","ue"));
        System.out.println(maxLength(arr));
    }

    public static int maxLength(List<String> arr) {
        return f(0, "", arr);
    }

    public static int f(int idx, String s, List<String> arr){
        if(idx >= arr.size()){
            return 0;
        }

        int leave = 0 + f(idx + 1, s, arr);

        int take = Integer.MIN_VALUE;
        if(uniqueChars(s + arr.get(idx))){
            take = arr.get(idx).length() + f(idx + 1, s + arr.get(idx), arr);
        }

        return Math.max(take, leave);
    }

    public static boolean uniqueChars(String s){
        int[] charCount = new int[26];

        for(char ch : s.toCharArray()){
            if(charCount[ch - 'a']++ > 0){
                return false;
            }

        }
        return true;
    }
}