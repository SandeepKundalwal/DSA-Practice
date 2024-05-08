import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int score[] = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int maxScore = Arrays.stream(score).max().getAsInt();

        int ranks[] = new int[maxScore + 1];
        Arrays.fill(ranks, -1);

        for(int i = 0; i < n; i++){
            ranks[score[i]] = i;
        }

        int position = 1;
        String answer[] = new String[n];
        for(int i = maxScore; i >= 0; i--){
            if(ranks[i] != -1){
                if(position <= 3){
                    answer[ranks[i]] = position == 1 ? "Gold Medal" :
                            position == 2 ? "Silver Medal" : "Bronze Medal";
                } else {
                    answer[ranks[i]] = String.valueOf(position);
                }
                position++;
            }
        }

        return answer;
    }
}