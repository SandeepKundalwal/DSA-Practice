public class Main {
    public static void main(String[] args) {
        String s = "bananas";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int freq[] = new int[128];

        for(char c : s.toCharArray()){
            freq[c]++;
        }

        int length = 0;
        boolean containsOddFreq = false;
        for(int i = 0; i < 128; i++){
            if(freq[i] % 2 == 0){
                length += freq[i];
            } else {
                length += freq[i] - 1;
                containsOddFreq = true;
            }
        }


        return containsOddFreq ? length + 1 : length;
    }
}