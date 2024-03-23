import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Series(10)));
    }

    static int MOD = (int) 1e9 + 7;
    static int[] Series(int n) {
        // code here
        int fib[] = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i <= n; i++){
            fib[i] = (fib[i - 1] % MOD + fib[i - 2] % MOD) % MOD;
        }

        return fib;
    }
}