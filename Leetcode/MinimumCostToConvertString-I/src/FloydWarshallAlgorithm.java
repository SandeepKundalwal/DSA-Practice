public class FloydWarshallAlgorithm {

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int m = source.length();
        int n = original.length;

        long d[][] = new long[26][26];
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j){
                    d[i][j] = 0;
                } else {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < n; i++){
            int u = original[i] - 'a';
            int v = changed[i] - 'a';

            d[u][v] = Math.min(d[u][v], (long)cost[i]);
        }


        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(d[i][j] > d[i][k] + d[k][j]){
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }



        long minCost = 0;
        for(int i = 0; i < m; i++){
            int src = source.charAt(i) - 'a';
            int des = target.charAt(i) - 'a';

            long c = d[src][des];

            if(c >= Integer.MAX_VALUE){
                return -1;
            } else {
                minCost += c;
            }
        }

        return minCost;
    }
}
