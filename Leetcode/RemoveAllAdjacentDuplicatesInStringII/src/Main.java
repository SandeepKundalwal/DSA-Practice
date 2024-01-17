import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        String s = "pbbcggttciiiippooaai";
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Alphabet> stack = new Stack<>();
        for(char character : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Alphabet(character, 1));
            } else {
                if(stack.peek().character == character){
                    Alphabet currentCharacter = stack.pop();
                    currentCharacter.frequency += 1;

                    if(currentCharacter.frequency < k){
                        stack.push(currentCharacter);
                    }
                } else {
                    stack.push(new Alphabet(character, 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Alphabet alphabet = stack.pop();
            sb.append((Character.toString(alphabet.character)).repeat(alphabet.frequency));
        }
        return sb.reverse().toString();
    }

    static class Alphabet{
        char character;
        int frequency;

        public Alphabet(char character, int frequency){
            this.character = character;
            this.frequency = frequency;
        }
    }
}