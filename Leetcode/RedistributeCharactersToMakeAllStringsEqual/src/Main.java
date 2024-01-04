public class Main {
    public static void main(String[] args) {
        String words[] = {"abc","aabc","bc"};
        System.out.println(makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {
        int frequency[] = new int[26];
        for(String word : words){
            for(char letter : word.toCharArray()){
                frequency[letter - 'a']++;
            }
        }

        int n = words.length;
        for(int freq : frequency){
            if(freq % n != 0){
                return false;
            }
        }
        return true;
    }
}