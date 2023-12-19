import java.util.Arrays;

public class Main {
    static int directions[][] = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}
    };
    public static void main(String[] args) {
        int img[][] = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        System.out.println(Arrays.deepToString(imageSmoother(img)));
    }

    public static int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int smoothenedImg[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int cnt = 1;
                int sum = img[i][j];
                for(int direction[] : directions){
                    int dI = i + direction[0];
                    int dJ = j + direction[1];

                    if(isValid(dI, dJ, n, m)){
                        cnt++;
                        sum += img[dI][dJ];
                    }
                }

                smoothenedImg[i][j] = (int) Math.floor(sum / cnt);
            }
        }

        return smoothenedImg;
    }

    public static boolean isValid(int i, int j, int n, int m){
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
}