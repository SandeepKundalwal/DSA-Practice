public class Main {
    public static void main(String[] args) {
        int N = 5;
        String S = "ACACB";
        System.out.println(luckyString(N, S));
    }

    public static int luckyString(int N, String S) {
        // code here
        if(N < 2){
            return 0;
        }

        if(S.charAt(0) == 'A' && S.charAt(1) == 'A'){
            return 2;
        }

        int mini = Integer.MAX_VALUE;
        int freq[] = new int[3];
        int left = 0, right = 0;
        while(right < N){
            char rC = S.charAt(right);
            freq[rC - 'A']++;
            while(left < right && freq[0] > 1){
                if(freq[0] > freq[1] && freq[0] > freq[2]){
                    mini = Math.min(mini, right - left + 1);
                }
                char lC = S.charAt(left);
                freq[lC - 'A']--;
                left++;
            }
            right++;
        }

        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}