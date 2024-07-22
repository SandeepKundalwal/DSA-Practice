public class Main {
    public static void main(String[] args) {
        String s = "leetcoder";
        System.out.println(doesAliceWin(s));
    }

    public static boolean doesAliceWin(String s) {
        for(char c : s.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                return true;
            }
        }

        return false;
    }
}