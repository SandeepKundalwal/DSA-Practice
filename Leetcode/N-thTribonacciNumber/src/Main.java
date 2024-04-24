public class Main {
    public static void main(String[] args) {
        System.out.println(tribonacci(24));
    }

    public static int tribonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1 || n == 2) return 1;

        int DP[] = new int[n + 1];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 1;

        for(int i = 3; i <= n; i++){
            DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];
        }

        return DP[n];
    }
}