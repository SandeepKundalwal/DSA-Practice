import java.util.HashMap;
import java.util.Map;

public class Main {
    static int MOD = (int)(1e9 + 7);
    static int directions[][] = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1 ,2}, {-1, 2}, {1, -2}, {-1, -2}
    };
    public static void main(String[] args) {
        int n = 1;
        System.out.println(knightDialer(n));
    }

    public static int knightDialer(int n) {
        int validJumps = 0;
        char dialPad[][] = new char[][]{
                {'#', '#', '#'},
                {'#', '#', '#'},
                {'#', '#', '#'},
                {'.', '#', '.'}
        };

        Map<String, Integer> MEMO = new HashMap<>();
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 2; j++){
                validJumps = ((validJumps % MOD) + (possibleJumps(i, j, n, dialPad, MEMO) % MOD) % MOD);
            }
        }
        return validJumps % MOD;
    }

    public static int possibleJumps(int positionI, int positionJ, int n, char dialPad[][], Map<String, Integer> MEMO){
        if(!outsideBound(positionI, positionJ, 4, 3, dialPad)){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        String key = positionI + "-" + positionJ + "-" + n;
        if(MEMO.containsKey(key)){
            return MEMO.get(key);
        }

        int count = 0;
        for(int direction[] : directions){
            int dPositionI = positionI + direction[0];
            int dPositionJ = positionJ + direction[1];
            count = ((count % MOD) + (possibleJumps(dPositionI, dPositionJ, n - 1, dialPad, MEMO) % MOD) % MOD);
        }

        MEMO.put(key, count % MOD);
        return MEMO.get(key);
    }

    public static boolean outsideBound(int positionI, int positionJ, int m, int n, char dialPad[][]){
        return (positionI >= 0 && positionI < m && positionJ >= 0 && positionJ < n && dialPad[positionI][positionJ] != '.');
    }
}