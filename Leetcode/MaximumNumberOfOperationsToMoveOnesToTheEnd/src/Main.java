public class Main {
    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
    }

    public static int maxOperations(String s) {
        int zeroes = 0;
        int maxOperations = 0;

        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == '1'){
                maxOperations += zeroes;
                i--;
            } else {
                zeroes++;
                while(i >= 0 && s.charAt(i) == '0'){
                    i--;
                }
            }
        }

        return maxOperations;
    }
}