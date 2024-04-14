public class Main {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }

    public static int scoreOfString(String s) {
        int sum = 0;

        for(int i = 1; i < s.length(); i++){
            sum += (Math.abs(s.charAt(i - 1) - s.charAt(i)));
        }

        return sum;
    }
}