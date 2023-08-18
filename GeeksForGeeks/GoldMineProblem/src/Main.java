public class Main {

    static int directions[][] = {
            {-1, +1}, {0, +1}, {+1, +1}
    };
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int M[][] = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };
        System.out.println("Maximum Gold Collected: " + maxGold(n, m, M));
    }

    public static int maxGold(int n, int m, int M[][]) {
        // code here
        int maxM[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            maxM[i][0] = M[i][0];
        }

        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                for(int direction[] : directions){
                    int dI = i + direction[0];
                    int dJ = j + direction[1];

                    if(isValid(dI, dJ, n, m)){
                        maxM[dI][dJ] = Math.max(maxM[dI][dJ] , maxM[i][j] + M[dI][dJ]);
                    }
                }
            }
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, maxM[i][m - 1]);
        }

        return maxi;
    }

    public static boolean isValid(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}