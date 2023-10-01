public class Main {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String words[] = s.split(" ");
        s = new String();
        for(String word : words){
            s += reverseWord(word) + " ";
        }
        return s.trim();
    }

    public static String reverseWord(String word){
        StringBuilder reverseWord = new StringBuilder();
        for(int i = word.length() - 1; i >= 0; i--){
            reverseWord.append(word.charAt(i));
        }
        return reverseWord.toString();
    }
}