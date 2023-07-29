public class Main {
    public static void main(String[] args) {
        int n = 100;
        System.out.println("Probability: " + soupServings(n));
    }

    /**
     Operations:
     1. 100ml -> A;  0ml -> B
     2.  75ml -> A; 25ml -> B
     3.  50ml -> A; 50ml -> B
     4.  25ml -> A; 75ml -> B
     */
    public static double soupServings(int n) {
        if(n >= 5000){
            return 1.0;
        }

        int operations[][] = new int[][]{
                {4 ,0}, {3, 1}, {2, 2}, {1, 3}
        };

        int N = (int) Math.ceil(n / 25.0);

        double MEMO[][] = new double[N + 1][N + 1];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                MEMO[i][j] = -1;
            }
        }
        return f(N, N, operations, MEMO);
    }

    public static double f(int A, int B, int operations[][], double MEMO[][]){
        if(A <= 0 || B <= 0){
            if(A <= 0 && B <= 0){
                return 0.5;
            }
            return (A <= 0 ? 1.0 : 0.0);
        }

        if(MEMO[A][B] != -1.0){
            return MEMO[A][B];
        }

        double probability = 0.0;
        for(int operation[] : operations){
            probability += f(A - operation[0], B - operation[1], operations, MEMO);
        }

        return MEMO[A][B] = 0.25 * probability;
    }
}