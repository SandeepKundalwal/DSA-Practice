public class Main {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxy";
        String text = "cba";
        System.out.println(calculateTime(keyboard, text));
    }

    public static int calculateTime(String keyboard, String text){
        int time = 0;

        int currPosition = 0;
        for(char c : text.toCharArray()){
            time += Math.abs(currPosition - (c - 'a'));
            currPosition = (c - 'a');
        }

        return time;
    }
}