public class Main {
    public static void main(String[] args) {
        int skills[] = {18,12,20};
        int k = 2;
        System.out.println(findWinningPlayer(skills, k));
    }

    public static int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;

        int maxIdx = 0;
        int consecutiveWins = 0;
        for(int i = 1; i < n; i++){
            if(skills[maxIdx] >= skills[i]){
                consecutiveWins++;
            } else {
                maxIdx = i;
                consecutiveWins = 1;
            }

            if(consecutiveWins >= k) break;
        }

        return maxIdx;
    }
}