public class Main {
    public static void main(String[] args) {
        System.out.println("Extra Character added: " + findTheDifference("abd", "absd"));
    }

    public static char findTheDifference(String s, String t) {
        int frequency[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            frequency[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            frequency[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(frequency[i] < 0){
                return (char)(i + 'a');
            }
        }

        return ' ';
    }
}