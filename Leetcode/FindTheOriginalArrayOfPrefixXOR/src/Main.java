import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int pref[] = {5,2,0,3,1};
        System.out.println(Arrays.toString(findArray(pref)));
    }

    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int result[] = new int[n];
        result[0] = pref[0];

        for(int i = 1; i < n; i++){
            int num = pref[i - 1] ^ pref[i];
            result[i] = num;
            pref[i] = pref[i - 1] ^ num;
        }

        return result;
    }
}