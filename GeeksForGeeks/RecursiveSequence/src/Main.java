public class Main {
    static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        System.out.println(sequence(5));
    }

    static long sequence(int n){
        return f(n);
    }

    static long f(int n){
        long ans = 1;
        int currNo = 2;
        for(int term = 2; term <= n; term++){
            long curr = 1;
            for(int i = 0; i < term; i++){
                curr = (curr * currNo) % MOD;
                currNo++;
            }
            ans = (ans % MOD + curr % MOD) % MOD;
        }
        return ans % MOD;
    }
}