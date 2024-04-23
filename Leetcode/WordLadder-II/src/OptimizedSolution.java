import java.util.*;

public class OptimizedSolution {
    String b;
    Map<String, Integer> map = new HashMap<>();
    List<List<String>> shortestTransformations = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        b = beginWord;
        map.put(beginWord, 1);

        Set<String> dictionary = new HashSet<>(wordList);
        dictionary.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int size = beginWord.length();
        while(!queue.isEmpty()){
            String word = queue.remove();

            if(word.equals(endWord)){
                break;
            }

            int steps = map.get(word);
            for(int i = 0; i < size; i++){
                char wordArr[] = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    wordArr[i] = c;
                    String newWord = new String(wordArr);
                    if(dictionary.contains(newWord)){
                        queue.offer(newWord);
                        dictionary.remove(newWord);
                        map.put(newWord, steps + 1);
                    }
                }
            }
        }

        if(map.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return shortestTransformations;
    }

    public void dfs(String word, List<String> seq){
        if(word.equals(b)){
            Collections.reverse(seq);
            shortestTransformations.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }

        int size = word.length();
        int steps = map.get(word);
        for(int i = 0; i < size; i++){
            char wordArr[] = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++){
                wordArr[i] = c;
                String newWord = new String(wordArr);
                if(map.containsKey(newWord) && map.get(newWord) + 1 == steps){
                    seq.add(newWord);
                    dfs(newWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}
