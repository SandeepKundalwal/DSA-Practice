public class Main {
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        int charsFrequency[] = new int[26];
        for(char c : s.toCharArray()){
            charsFrequency[c - 'a']++;
        }

        int minLength = 0;
        for(int charFrequency : charsFrequency){
            if(charFrequency == 0) continue;

            if(charFrequency % 2 == 0){
                minLength += 2;
            } else {
                minLength += 1;
            }
        }

        return minLength;
    }
}