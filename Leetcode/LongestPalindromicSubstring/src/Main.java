public class Main {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String lP = new String();

        for(int i = 0; i < s.length(); i++){
            String evenLP = palindrome(i, i + 1, s);
            String oddLP = palindrome(i, i, s);

            if(evenLP.length() > oddLP.length()){
                if(lP.length() < evenLP.length()){
                    lP = evenLP;
                }
            } else {
                if(lP.length() < oddLP.length()){
                    lP = oddLP;
                }
            }
        }

        return lP;
    }

    public static String palindrome(int i, int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }
}