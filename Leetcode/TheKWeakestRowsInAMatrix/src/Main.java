import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int mat[][] = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    static class Pair{
        int index;
        int strength;
        public Pair(int index, int strength){
            this.index = index;
            this.strength = strength;
        }
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        Pair rowsStrength[] = new Pair[m];

        for(int i = 0; i < m; i++){
            rowsStrength[i] = new Pair(i, 0);
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    rowsStrength[i].strength++;
                } else {
                    break;
                }
            }
        }

        int result[] = new int[k];
        Arrays.sort(rowsStrength, (a, b) -> a.strength - b.strength);
        for(int i = 0; i < k; i++){
            result[i] = rowsStrength[i].index;
        }
        return result;
    }
}