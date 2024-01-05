import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        String s = "aabbaa";
        System.out.println(getLengthOfOptimalCompression(s, k));
    }

    public static int getLengthOfOptimalCompression(String s, int k) {
        int MEMO[][][][] = new int[s.length()][27][101][k + 1];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 27; j++){
                for(int l = 0; l < 101; l++){
                    Arrays.fill(MEMO[i][j][l], -1);
                }
            }
        }
        return f(0, 26, 0, s.toCharArray(), k, MEMO);
    }

    private static int f(int idx, int prevChar, int prevLength, char sArr[], int k, int MEMO[][][][]){
        if(k < 0){
            return Integer.MAX_VALUE;
        }

        if(idx >= sArr.length){
            return 0;
        }

        if(MEMO[idx][prevChar][prevLength][k] != -1){
            return MEMO[idx][prevChar][prevLength][k];
        }

        int deleteChar = f(idx + 1, prevChar, prevLength, sArr, k - 1, MEMO);

        int keepChar = 0;
        if(sArr[idx] - 'a' == prevChar){
            keepChar = f(idx + 1, prevChar, prevLength + 1, sArr, k, MEMO) + (prevLength == 1 ? 1 : prevLength == 9 ? 1 : prevLength == 99 ? 1 : 0);
        } else {
            keepChar = f(idx + 1, sArr[idx] - 'a', 1, sArr, k, MEMO) + 1;
        }

        return MEMO[idx][prevChar][prevLength][k] = Math.min(deleteChar, keepChar);
    }
}