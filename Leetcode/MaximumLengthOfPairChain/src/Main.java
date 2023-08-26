import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int pairs[][] = {
                {1,2},{2,3},{3,4}
        };
        System.out.println("Number of Pair: " + findLongestChain(pairs));
    }

    private static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n == 1){
            return 1;
        }

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int[][] MEMO = new int[n][n + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n + 1; j++){
                MEMO[i][j] = -1;
            }
        }
        return f(0, -1, n, pairs, MEMO);
    }

    private static int f(int idx, int prevIdx, int n, int[][] pairs, int[][] MEMO){
        if(idx == n){
            return 0;
        }

        if(MEMO[idx][prevIdx + 1] != -1){
            return MEMO[idx][prevIdx + 1];
        }

        int dontTake = 0 + f(idx + 1, prevIdx, n, pairs, MEMO);
        int take = Integer.MIN_VALUE;
        if(prevIdx == -1 || pairs[prevIdx][1] < pairs[idx][0]){
            take = 1 + f(idx + 1, idx, n, pairs, MEMO);
        }

        return MEMO[idx][prevIdx + 1] = Math.max(take, dontTake);
    }
}