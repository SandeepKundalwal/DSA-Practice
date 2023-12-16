public class Main {
    public static void main(String[] args) {
        System.out.println(isAnagram("car", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        int frequency[] = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        for(int freq : frequency){
            if(freq != 0){
                return false;
            }
        }

        return true;
    }
}