import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String word = "abDBAbb";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        int count = 0;
        Set<Character> upperCase = new HashSet<>();
        Set<Character> invalidCharacters = new HashSet<>();

        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                upperCase.add(c);
            } else if(upperCase.contains(Character.toUpperCase(c))){
                invalidCharacters.add(c);
            }
        }

        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c) && upperCase.contains(Character.toUpperCase(c)) && !invalidCharacters.contains(c)){
                count++;
                upperCase.remove(Character.toUpperCase(c));
            }
        }


        return count;
    }
}