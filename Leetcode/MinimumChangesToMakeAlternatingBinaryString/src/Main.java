public class Main {
    public static void main(String[] args) {
        String s = "0010";
        System.out.println(minOperations(s));
    }

    public static int minOperations(String s) {
        int minOperationsFirst = 0;

        for(int i = 1; i < s.length(); i += 2){
            if(s.charAt(i - 1) != '1'){
                minOperationsFirst++;
            }

            if(s.charAt(i) != '0'){
                minOperationsFirst++;
            }
        }

        if(s.length() % 2 != 0){
            if(s.charAt(s.length() - 1) != '1'){
                minOperationsFirst++;
            }
        }

        int minOperationsSecond = 0;
        for(int i = 1; i < s.length(); i += 2){
            if(s.charAt(i - 1) != '0'){
                minOperationsSecond++;
            }

            if(s.charAt(i) != '1'){
                minOperationsSecond++;
            }
        }

        if(s.length() % 2 != 0){
            if(s.charAt(s.length() - 1) != '0'){
                minOperationsSecond++;
            }
        }

        return Math.min(minOperationsFirst, minOperationsSecond);
    }
}