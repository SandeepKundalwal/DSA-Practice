import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "aA";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        int firstIdx = 0;
        int secondIdx = s.length() / 2;

        int countFirstHalf = 0;
        while(firstIdx < secondIdx){
            if(vowelSet.contains(s.charAt(firstIdx++))){
                countFirstHalf++;
            }
        }

        int countSecondHalf = 0;
        while(secondIdx < s.length()){
            if(vowelSet.contains(s.charAt(secondIdx++))){
                countSecondHalf++;
            }
        }

        return countFirstHalf == countSecondHalf;
    }
}