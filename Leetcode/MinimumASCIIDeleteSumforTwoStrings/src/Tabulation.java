public class Tabulation {
    /**
     LCS Most Probably.
     */
    public static int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int prefixS1[] = new int[n1];
        int prefixS2[] = new int[n2];

        for(int i = 0; i < n1; i++){
            if(i == 0){
                prefixS1[i] = (int)s1.charAt(i);
            } else {
                prefixS1[i] = prefixS1[i - 1] + (int)s1.charAt(i);
            }
        }

        for(int j = 0; j < n2; j++){
            if(j == 0){
                prefixS2[j] = (int)s2.charAt(j);
            } else {
                prefixS2[j] = prefixS2[j - 1] + (int)s2.charAt(j);
            }
        }

        int DP[][] = new int[n1 + 1][n2 + 1];

        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0 || j == 0){
                    if(i == 0 && j == 0){
                        DP[i][j] = 0;
                    } else if(i == 0){
                        DP[i][j] = prefixS2[j - 1];
                    } else {
                        DP[i][j] = prefixS1[i - 1];
                    }
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    DP[i][j] = 0 + DP[i - 1][j -1];
                } else {
                    DP[i][j] = Math.min((int)s1.charAt(i - 1) + DP[i - 1][j], (int)s2.charAt(j - 1) + DP[i][j - 1]);
                }
            }
        }

        return DP[n1][n2];
    }
}
