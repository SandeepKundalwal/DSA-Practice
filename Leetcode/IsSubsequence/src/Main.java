public class Main {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "adbsck"));
    }

    public static boolean isSubsequence(String s, String t) {
        int idx = 0;
        for(int i = 0; i < t.length(); i++){
            if(idx < s.length() && t.charAt(i) == s.charAt(idx)){
                idx++;
            }
        }
        return idx == s.length();
    }
}
