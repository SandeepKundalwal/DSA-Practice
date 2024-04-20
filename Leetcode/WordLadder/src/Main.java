import java.util.*;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);

        if(!dictionary.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                char[] word = queue.remove().toCharArray();
                for(int j = 0; j < word.length; j++){
                    char temp = word[j];

                    for(char c = 'a'; c <= 'z'; c++){
                        word[j] = c;
                        String newWord = new String(word);

                        if(newWord.equals(endWord)){
                            return level + 1;
                        }

                        if(dictionary.contains(newWord)){
                            queue.offer(newWord);
                            dictionary.remove(newWord);
                        }
                    }

                    word[j] = temp;
                }
            }
            level++;
        }

        return 0;
    }
}