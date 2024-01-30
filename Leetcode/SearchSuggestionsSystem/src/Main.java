import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String searchWord = "mouse";
        String products[] = {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(suggestedProducts(products, searchWord));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        trie.insertWords(products);

        List<List<String>> suggestions = new ArrayList<>();

        StringBuilder prefix = new StringBuilder();
        for(char c : searchWord.toCharArray()){
            prefix.append(c);
            suggestions.add(trie.getWordStartingWith(prefix));
        }
        return suggestions;
    }
}