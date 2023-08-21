public class Main {
    public static void main(String[] args) {
        System.out.println("Possible? " + repeatedSubstringPattern("abab"));
    }

    // O(n.sqrt(n))
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1){
            return false;
        }

        for(int i = 0; i < s.length() / 2; i++){
            String substring = s.substring(0, i + 1);
            int isMultiple = s.length() % substring.length();
            if(isMultiple == 1){
                continue;
            } else {
                int appendFor = s.length() / substring.length();
                String newString = substring.repeat(appendFor);
                if(newString.equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}