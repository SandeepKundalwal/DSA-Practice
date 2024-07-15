public class Main {
    public static void main(String[] args) {
        String word = "aaaaaaaaaaaaaabb";
        System.out.println(compressedString(word));
    }

    public static String compressedString(String word) {
        int n = word.length();
        StringBuilder comp = new StringBuilder();

        int idx = 0;
        while(idx < n){
            char c = word.charAt(idx);

            idx++;
            int cnt = 1;
            while(idx < n && cnt < 9 && c == word.charAt(idx)){
                cnt++;
                idx++;
            }

            comp.append(cnt).append(c);
        }

        return comp.toString();
    }
}