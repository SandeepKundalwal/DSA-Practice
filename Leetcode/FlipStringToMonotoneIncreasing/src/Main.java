public class Main {
    public static void main(String[] args) {
        String s = "0101100011";
        System.out.println(minFlipsMonoIncr(s));
    }

    public static int minFlipsMonoIncr(String s) {
        int countZ = 0, countO = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                countZ++;
            } else {
                countO++;
            }
        }

        int countFlips = 0;
        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < right && s.charAt(left) == '0'){
                left++;
                countZ--;
            }

            while(right > left && s.charAt(right) == '1'){
                right--;
                countO--;
            }

            if(countZ < countO){
                while(right > left && s.charAt(right) == '0'){
                    right--;
                    countZ--;
                    countFlips++;
                }
            } else {
                while(left < right && s.charAt(left) == '1'){
                    left++;
                    countO--;
                    countFlips++;
                }
            }
        }

        return countFlips;
    }
}