public class Main {
    public static void main(String[] args) {
        String s = "abada";
        char c = 'a';
        System.out.println(countSubstrings(s, c));
    }

    public static long countSubstrings(String s, char c) {
        int count = 0;

        for(char ch : s.toCharArray()){
            if(ch == c) count++;
        }

        return ((long) count * (count + 1)) / 2;
    }
}