import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int low = 100;
        int high = 1300;
        System.out.println(sequentialDigits(low, high));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        int startDigits = Integer.toString(low).length();
        int endDigits = Integer.toString(high).length();

        String digits = "123456789";
        for(int i = startDigits; i <= endDigits; i++){
            for(int j = 0; j <= digits.length() - i; j++){
                int no = Integer.parseInt(digits.substring(j, j + i));
                if(no >= low && no <= high){
                    result.add(no);
                }
            }
        }
        return result;
    }
}