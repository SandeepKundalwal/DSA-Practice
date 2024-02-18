import java.util.HashMap;
import java.util.Map;

public class Main {
    static int directions[][] = {
            {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
    };
    public static void main(String[] args) {
        int mat[][] = {
                {9,3,8},{4,2,5},{3,8,6}
        };
        System.out.println(mostFrequentPrime(mat));
    }


    public static int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int d = 0; d < 8; d++){
                    f(i, j, mat, directions[d], hashMap);
                }
            }
        }

        int maxi = 0;
        int maxFreq = 0;
        for(Map.Entry<Integer, Integer> it : hashMap.entrySet()){
            int key = it.getKey();
            int val = it.getValue();

            if(val >= maxFreq){
                maxFreq = val;
                maxi = Math.max(maxi, key);
            }
        }

        return maxi == 0 ? -1 : maxi;
    }

    public static void f(int i, int j, int mat[][], int direction[], Map<Integer, Integer> hashMap){
        int m = mat.length;
        int n = mat[0].length;

        StringBuilder no = new StringBuilder(Integer.toString(mat[i][j]));
        while(insideBoundary(i, j, m, n)){
            i = i + direction[0];
            j = j + direction[1];
            if(insideBoundary(i, j, m, n)){
                no.append(mat[i][j]);
                int currNo = Integer.parseInt(no.toString());
                if(isPrime(currNo)){
                    if(!hashMap.containsKey(currNo)){
                        hashMap.put(currNo, 0);
                    }
                    hashMap.put(currNo, hashMap.get(currNo) + 1);
                }
            }

        }
    }

    public static boolean insideBoundary(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static boolean isPrime(int num){
        for(int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}