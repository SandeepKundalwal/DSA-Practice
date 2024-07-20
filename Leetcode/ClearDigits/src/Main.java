public class Main {
    public static void main(String[] args) {
        String s = "cab34";
        System.out.println(clearDigits(s));
    }

    public static String clearDigits(String s) {
        int n = s.length();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                result.append(c);
            } else {
                result.deleteCharAt(result.length() - 1);
            }
        }

        return result.toString();
    }
}