public class Main {
    public static void main(String[] args) {
        String word = "234Adas";
        System.out.println(isValid(word));
    }

    public static boolean isValid(String word) {
        if(word.length() < 3) return false;

        boolean letter = false;
        boolean foundVowel = false;
        boolean foundConsonant = false;

        String vowels = "aeiouAEIOU";
        for(char c : word.toCharArray()){
            if(Character.isDigit(c)){
                continue;
            } else if(Character.isLetter(c)){
                if(vowels.contains(Character.toString(c))){
                    foundVowel = true;
                } else {
                    foundConsonant = true;
                }
                letter = true;
            } else {
                return false;
            }
        }

        return letter && foundVowel && foundConsonant;
    }
}