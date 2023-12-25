import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int numDecodings(String s) {
        int MEMO[] = new int[s.length() + 1];
        Arrays.fill(MEMO, -1);
        return f(0, s, MEMO);
    }

    public static int f(int index, String s, int MEMO[]){
        if(index >= s.length()){
            return 1;
        }

        if(MEMO[index] != -1) {
            return MEMO[index];
        }

        int cnt = 0;
        for(int i = index; i < s.length(); i++){
            String sNo = s.substring(index, i + 1);
            int no = Integer.parseInt(sNo);
            if(sNo.charAt(0) == '0') continue;
            if(no > 26) break;
            if(no >= 1){
                cnt += f(i + 1, s, MEMO);
            }
        }

        return MEMO[index] = cnt;
    }
}