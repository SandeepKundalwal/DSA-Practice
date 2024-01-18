import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
        int MEMO[] = new int[n + 1];
        Arrays.fill(MEMO, -1);
        return f(n, MEMO);
    }

    public static int f(int n, int MEMO[]){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(MEMO[n] != -1){
            return MEMO[n];
        }

        return MEMO[n] = f(n -1, MEMO) + f(n - 2, MEMO);
    }
}