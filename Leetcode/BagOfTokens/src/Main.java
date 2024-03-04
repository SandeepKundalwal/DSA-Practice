import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int power = 100;
        int tokens[] = {200,100};
        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int score = 0, finalScore = 0;
        int left = 0, right = tokens.length - 1;
        while(left <= right){
            if(power >= tokens[left]){
                score++;
                power -= tokens[left++];
                finalScore = Math.max(score, finalScore);
            } else {
                if(score > 0){
                    score--;
                    power += tokens[right--];
                } else {
                    break;
                }
            }
        }

        return finalScore;
    }
}