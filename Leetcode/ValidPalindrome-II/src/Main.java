public class Main {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome((s)));
    }

    public static boolean validPalindrome(String s) {
        if(s.length() == 0) return true;

        int i = 0;
        int j = s.length() - 1;

        while( i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isValidPalindrome(s, i + 1, j) || isValidPalindrome(s, i, j - 1);
            } else{
                i++;
                j--;
            }
        }

        return true;
    }

    public static boolean isValidPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}