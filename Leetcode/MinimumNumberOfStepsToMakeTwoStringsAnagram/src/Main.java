public class Main {
    public static void main(String[] args) {
        String s = "aba";
        String t = "bab";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        int freq[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        int minSteps = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                minSteps += freq[i];
            }
        }

        return minSteps;
    }
}