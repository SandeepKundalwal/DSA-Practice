public class Main {
    public static void main(String[] args) {
        System.out.println(count(15));
    }

    public static long count(int n) {
        int moves[] = {3,5,10};

        long DP[] = new long[n + 1];
        DP[0] = 1;
        for(int idx = 0; idx < 3; idx++){
            for(int i = moves[idx]; i <= n; i++){
                DP[i] += DP[i - moves[idx]];
            }
        }
        return DP[n];
    }
}