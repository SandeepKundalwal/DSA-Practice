import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int piles[] = {2,7,9,4,4};
        System.out.println(stoneGameII(piles));
    }

    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        int MEMO[][][] = new int[n][n + 1][2];
        for(int twoD[][] : MEMO){
            for(int oneD[] : twoD){
                Arrays.fill(oneD, -1);
            }
        }

        return f(0, 1, 0, piles, MEMO);
    }

    public static int f(int idx, int M, int turn, int piles[], int MEMO[][][]){
        if(idx >= piles.length){
            return 0;
        }

        if(MEMO[idx][M][turn] != -1){
            return MEMO[idx][M][turn];
        }

        int totalStones = 0;
        int result = turn == 0 ? 0 : Integer.MAX_VALUE;
        for(int X = 1; X <= 2 * M; X++){
            if(idx + X > piles.length){
                break;
            }

            totalStones += piles[idx + X - 1];
            if(turn == 0){
                result = Math.max(result, totalStones + f(idx + X, Math.max(M, X), turn ^ 1, piles, MEMO));
            } else {
                result = Math.min(result, f(idx + X, Math.max(M, X), turn ^ 1, piles, MEMO));
            }
        }

        return MEMO[idx][M][turn] = result;
    }
}