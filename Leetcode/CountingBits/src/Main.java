import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int ans[] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int cnt = 0;
            for(int k = 0; k < 32; k++){
                if((i & (1 << k)) != 0){
                    cnt++;
                }
            }
            ans[i] = cnt;
        }

        return ans;
    }
}