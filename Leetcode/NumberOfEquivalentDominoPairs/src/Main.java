public class Main {
    public static void main(String[] args) {
        int dominoes[][] = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int DP[][] = new int[10][10];
        for(int domino[] : dominoes){
            int i = domino[0];
            int j = domino[1];

            if(i != j){
                DP[i][j]++;
            }

            DP[j][i]++;
        }

        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = i; j < 10; j++){
                if(DP[i][j] > 1){
                    int c = DP[i][j] - 1;
                    count += (c * (c + 1) / 2);
                }
            }
        }

        return count;
    }
}