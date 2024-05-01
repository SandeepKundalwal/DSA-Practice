public class Main {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        int n = word.length();

        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < n; i++){
            if(word.charAt(i) == ch){
                StringBuilder newWord = new StringBuilder(word.substring(0, i + 1));
                return newWord.reverse() + word.substring(i + 1);
            }
        }

        return word;
    }
}