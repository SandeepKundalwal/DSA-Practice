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
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else {
                if(sCounts[guess.charAt(i) - '0'] > 0){
                    cows++;
                    sCounts[guess.charAt(i) - '0']--;
                } else {
                    gCounts[guess.charAt(i) - '0']++;
                }

                if(gCounts[secret.charAt(i) - '0'] > 0){
                    cows++;
                    gCounts[secret.charAt(i) - '0']--;
                } else {
                    sCounts[secret.charAt(i) - '0']++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        return sb.append(bulls).append("A").append(cows).append("B").toString();
    }
}