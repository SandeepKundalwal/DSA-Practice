import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "adaddccdb";
        System.out.println(maximumLengthSubstring(s));
    }

    public static int maximumLengthSubstring(String s) {
        int n = s.length();

        int maxi = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        while(right < n){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);

                while(left < right && map.get(c) > 2){
                    // System.out.println(left + " " + right);
                    char cc = s.charAt(left);
                    map.put(cc, map.get(cc) - 1);
                    if(map.get(cc) <= 0){
                        map.remove(cc);
                    }
                    left++;
                }
            }

            maxi = Math.max(maxi, right - left + 1);
            right++;
        }

        return maxi;
    }
}