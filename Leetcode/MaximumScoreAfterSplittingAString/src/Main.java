public class Main {
    public static void main(String[] args) {
        String s = "0010";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int left = 0,  right = 0, maxScore = 0;

        for(char ch : s.toCharArray()){
            if(ch == '1') right++;
        }

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '0'){
                left++;
            } else {
                right--;
            }
            maxScore = Math.max(maxScore, left + right);
        }
        return maxScore;
    }
}