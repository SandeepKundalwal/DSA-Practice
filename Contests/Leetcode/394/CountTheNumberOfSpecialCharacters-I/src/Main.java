import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String word = "abBCab";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        Set<Character> upperCase = new HashSet<>();

        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                upperCase.add(c);
            }
        }

        int count = 0;
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c) && upperCase.contains(Character.toUpperCase(c))){
                count++;
                upperCase.remove(Character.toUpperCase(c));
            }
        }
        return count;
    }
}