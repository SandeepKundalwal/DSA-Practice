import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "egcd";
        String t = "adfd";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, t.charAt(i));
            } else {
                if(map.get(c) != t.charAt(i)){
                    return false;
                }
            }
        }

        map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, s.charAt(i));
            } else {
                if(map.get(c) != s.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }
}