public class Main {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int n = secret.length();

        int sCounts[] = new int[10];
        int gCounts[] = new int[10];
        int bulls = 0, cows = 0;
        for(int i = 0; i < n; i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            } else {
                if(sCounts[g - '0'] > 0){
                    cows++;
                    sCounts[g - '0']--;
                } else {
                    gCounts[g - '0']++;
                }

                if(gCounts[s - '0'] > 0){
                    cows++;
                    gCounts[s - '0']--;
                } else {
                    sCounts[s - '0']++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        return sb.append(bulls).append("A").append(cows).append("B").toString();
    }
}