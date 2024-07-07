import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(validStrings(3));
    }

    public static List<String> validStrings(int n) {
        List<String> validStrings = new ArrayList<>();
        f(new StringBuilder(), n, validStrings);
        return validStrings;
    }

    public static void f(StringBuilder sb, int n, List<String> validStrings){
        if(sb.length() >= n){
            validStrings.add(sb.toString());
            return;
        }

        if(sb.length() == 0 || sb.charAt(sb.length() - 1) == '1'){
            sb.append('0');
            f(sb, n, validStrings);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("1");
        f(sb, n, validStrings);
        sb.deleteCharAt(sb.length() - 1);
    }
}