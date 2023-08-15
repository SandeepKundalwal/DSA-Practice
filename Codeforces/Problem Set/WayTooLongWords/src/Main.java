import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String word = in.next();
            if(word.length() > 10){
                String abbreviation = word.charAt(0) + Integer.toString(word.substring(1, word.length() - 1).length()) + word.charAt(word.length() - 1);
                System.out.println(abbreviation);
            } else {
                System.out.println(word);
            }
        }
    }
}