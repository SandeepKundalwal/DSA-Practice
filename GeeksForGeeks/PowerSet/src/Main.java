import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(AllPossibleStrings(s));
    }

    public static List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> powerSet = new ArrayList<>();
        f(0, new String(), s, powerSet);
        Collections.sort(powerSet);
        return powerSet;
    }

    public static void f(int idx, String subsequence, String s, List<String> powerSet){
        if(idx >= s.length()){
            if(!subsequence.isEmpty()){
                StringBuilder temp = new StringBuilder(subsequence);
                powerSet.add(temp.reverse().toString());
            }
            return;
        }

        f(idx + 1, subsequence, s, powerSet);
        f(idx + 1, s.charAt(idx) + subsequence, s, powerSet);
    }
}