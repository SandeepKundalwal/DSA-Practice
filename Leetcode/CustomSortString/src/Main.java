public class Main {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            if(freq[c - 'a'] != 0){
                sb.append(String.valueOf(c).repeat(freq[c - 'a']));
                freq[c - 'a'] = 0;
            }
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                sb.append(String.valueOf((char)(i + 'a')).repeat(freq[i]));
            }
        }

        return sb.toString();
    }
}