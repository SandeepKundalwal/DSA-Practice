import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> allCombinations = new ArrayList<>();
        if(digits.length() == 0){
            return allCombinations;
        }

        String letterCorrespondence[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(0, new StringBuilder(), letterCorrespondence, digits, allCombinations);
        return allCombinations;
    }

    public static void backtrack(int idx, StringBuilder combination, String letterCorrespondence[], String digits, List<String> allCombinations){
        if(combination.length() == digits.length()){
            allCombinations.add(combination.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        for(int i = 0; i < letterCorrespondence[digit].length(); i++){
            combination.append(letterCorrespondence[digit].charAt(i));
            backtrack(idx + 1, combination, letterCorrespondence, digits, allCombinations);
            combination.deleteCharAt(combination.length() - 1);
        }

    }
}