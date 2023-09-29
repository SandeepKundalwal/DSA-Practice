public class Main {
    public static void main(String[] args) {
        int poured = 6;
        int query_row = 3;
        int query_glass = 1;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double DP[][] = new double[102][102];
        DP[0][0] = (double)poured;

        for(int i = 1; i < 102; i++){
            for(int j = 0; j < i; j++){
                double remainingWine = ((DP[i - 1][j] - 1) / 2.0);

                if(Double.compare(DP[i - 1][j], 1) > 0){
                    DP[i - 1][j] = 1.0;
                }

                // Distribute to j and j + 1;
                if(Double.compare(remainingWine, 0) > 0){
                    DP[i][j] += remainingWine;
                    DP[i][j + 1] += remainingWine;
                }
            }
        }

        return DP[query_row][query_glass];
    }
}