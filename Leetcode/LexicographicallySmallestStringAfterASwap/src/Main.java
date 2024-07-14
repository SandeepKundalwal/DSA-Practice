public class Main {
    public static void main(String[] args) {
        String s = "45320";
        System.out.println(getSmallestString(s));
    }

    public static String getSmallestString(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while(i < n - 1){
            int first = sb.charAt(i) - '0';
            int second = sb.charAt(i + 1) - '0';

            if(first % 2 == second % 2 && first > second){
                sb.setCharAt(i, (char)(second + '0'));
                sb.setCharAt(i + 1, (char)(first + '0'));
                break;
            }

            i++;
        }

        return sb.toString();
    }
}