public class Main {
    public static void main(String[] args) {
        String word = "abb";
        System.out.println(removeAlmostEqualCharacters(word));
    }

    public static int removeAlmostEqualCharacters(String word) {
        int minOperations = 0;

        for(int i = 1; i < word.length(); i++){
            if(Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1){
                minOperations++;
                i++;
            }
        }
        return minOperations;
    }
}