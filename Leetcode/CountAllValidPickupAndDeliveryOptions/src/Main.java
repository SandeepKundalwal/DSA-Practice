public class Main {
    static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        System.out.println(countOrders(458));
    }

    /**
     Most Probably a P&C Problem
     */
    public static int countOrders(int n) {
        if(n == 1){
            return 1;
        }

        long result = 1;
        for(int i = 2; i <= n; i++){
            result = result * (i * 2 - 1) * i % MOD;
        }
        return (int)result;
    }
}