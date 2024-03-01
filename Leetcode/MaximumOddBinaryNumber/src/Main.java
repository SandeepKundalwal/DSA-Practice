import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "0101";
        System.out.println(maximumOddBinaryNumber(s));
    }

    public static String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char sArr[] = new char[n];
        Arrays.fill(sArr, '0');

        int left = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '1'){
                if(sArr[n - 1] == '0'){
                    sArr[n - 1] = '1';
                } else {
                    sArr[left++] = '1';
                }
            }
        }

        return new String(sArr);
    }
}