public class FirstIntuition {
    public static String convertToTitle(int columnNumber) {
        char alphabets[] = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        if(columnNumber <= 26){
            return Character.toString(alphabets[columnNumber]);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = noOfLetters(columnNumber);
        while(cnt-- > 0){
            // log(n)
            int power = (int) Math.pow(26, cnt);
            int sumOfPreviousPowers = calculatePreviousPowers(cnt - 1);
            for(int j = 26; j > 0; j--){
                int totalPower = power * j;
                if(totalPower + sumOfPreviousPowers <= columnNumber){
                    sb.append(alphabets[j]);
                    columnNumber -= totalPower;
                }
            }
        }
        return sb.toString();
    }

    private static int noOfLetters(int columnNumber){
        int cnt = 0;
        int newNo = 1;
        while(newNo < columnNumber){
            newNo *= 26;
            cnt++;
        }
        return cnt;
    }

    private static int calculatePreviousPowers(int n){
        int sumPowers = 0;
        while(n > 0){
            sumPowers += (int) Math.pow(26, n);
            n--;
        }
        return sumPowers;
    }
}
