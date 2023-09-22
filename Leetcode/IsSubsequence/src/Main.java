public class Main {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "adbsck"));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.equals(t)){
            return true;
        }

        int idx = 0;
        int matchedCharacters = 0;
        for(int i = 0; i < t.length(); i++){
            if(idx < s.length() && t.charAt(i) == s.charAt(idx)){
                idx++;
                matchedCharacters++;
            }

            if(matchedCharacters == s.length()){
                return true;
            }
        }
        return false;
    }
}