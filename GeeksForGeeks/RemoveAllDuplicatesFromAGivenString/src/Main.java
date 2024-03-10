import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String str = "geEksforGEeks";
        System.out.println(removeDuplicates(str));
    }

    static String removeDuplicates(String str) {
        Set<Character> duplicates = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(!duplicates.contains(c)){
                sb.append(c);
                duplicates.add(c);
            }
        }
        return sb.toString();
    }
}