import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dictionary = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));

        Memoization memoization = new Memoization();
        System.out.println(memoization.wordBreak(s, dictionary));

        ZAlgorithm zAlgorithm = new ZAlgorithm();
        System.out.println(zAlgorithm.wordBreak(s, dictionary));

        Trie trie = new Trie();
        System.out.println(trie.wordBreak(s, dictionary));
    }
}