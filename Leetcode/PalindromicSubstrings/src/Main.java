public class Main {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            int left = i, right = i;
            count += (isPalindrome(i, i, s) + isPalindrome(i - 1, i, s));

        }
        return count;
    }

    public static int isPalindrome(int left, int right, String s){
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}