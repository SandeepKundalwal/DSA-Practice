public class Main {
    static int denominator = 2;
    static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        String s = "abbcccaa";
        System.out.println(countHomogenous(s));
    }

    public static int countHomogenous(String s) {
        int n = s.length(), left = 0, right = 0;
        int count = 0;
        while(right < n){
            if(s.charAt(right) != s.charAt(left)){
                count = ((count % MOD) + (countSubstring(right - left) % MOD)) % MOD;
                left = right;
            }
            right++;
        }

        if(right != left){
            count = ((count % MOD) + countSubstring(right - left) % MOD) % MOD;
        }

        return (count % MOD);
    }

    private static int countSubstring(int len){
        int numerator = multiplyMod(len, len + 1, MOD);
        int inverse = modInverse(denominator, MOD);
        return multiplyMod(numerator, inverse, MOD);
    }

    private static int multiplyMod(int a, int b, int mod) {
        return (int) ((long) a * b % mod);
    }

    private static int modInverse(int a, int mod) {
        int m0 = mod;
        int y = 0, x = 1;

        if (mod == 1) {
            return 0;
        }

        while (a > 1) {
            int q = a / mod;
            int t = mod;

            mod = a % mod;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        if (x < 0) {
            x += m0;
        }

        return x;
    }
}