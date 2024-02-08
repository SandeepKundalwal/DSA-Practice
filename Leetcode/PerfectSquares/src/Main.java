import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(numSquares(14));
    }

    public static int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        findPerfectSquares(n, perfectSquares);

        int MEMO[][] = new int[perfectSquares.size()][n + 1];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }
        return f(0, n, perfectSquares, MEMO);
    }

    public static int f(int idx, int n, List<Integer> perfectSquares, int MEMO[][]){
        if(n == 0){
            return 0;
        }

        if(idx >= perfectSquares.size()){
            return (int) 1e4;
        }

        if(MEMO[idx][n] != -1){
            return MEMO[idx][n];
        }

        int leave = 0 + f(idx + 1, n, perfectSquares, MEMO);

        int take = (int) 1e4;
        if(n - perfectSquares.get(idx) >= 0){
            take = Math.min(take, 1 + f(idx, n - perfectSquares.get(idx), perfectSquares, MEMO));
        }

        return MEMO[idx][n] = Math.min(leave, take);
    }

    public static void findPerfectSquares(int n, List<Integer> perfectSquares){
        for(int i = 1; i <= n; i++){
            if((double) (Math.sqrt(i)) % 1 == 0){
                perfectSquares.add(i);
            }
        }
    }
}