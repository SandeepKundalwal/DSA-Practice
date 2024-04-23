import java.util.*;

public class Main {
    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = List.of("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        System.out.println(findLadders(beginWord, endWord, wordList));

        System.out.println("\n*******************Optimized Solution*******************\n");
        OptimizedSolution optimizedSolution = new OptimizedSolution();
        System.out.println(optimizedSolution.findLadders(beginWord, endWord, wordList));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return new ArrayList<>();

        Set<String> dictionary = new HashSet<>(wordList);

        if(!dictionary.contains(endWord)) return new ArrayList<>();

        List<List<String>> shortestTransformations = new ArrayList<>();

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(List.of(beginWord)));

        List<String> usedWords = new ArrayList<>(List.of(beginWord));

        int level = 0;
        while(!queue.isEmpty()){
            List<String> words = queue.remove();

            if(words.size() > level){
                level++;
                for(String word : usedWords){
                    dictionary.remove(word);
                }
                usedWords.clear();
            }

            String lastWord = words.get(words.size() - 1);
            if(lastWord.equals(endWord)){
                if(shortestTransformations.isEmpty()){
                    shortestTransformations.add(new ArrayList<>(words));
                } else if(shortestTransformations.get(shortestTransformations.size() - 1).size() == words.size()){
                    shortestTransformations.add(new ArrayList<>(words));
                } else {
                    break;
                }
            }

            for(int i = 0; i < lastWord.length(); i++){
                char lastWordArr[] = lastWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    lastWordArr[i] = c;
                    String newWord = new String(lastWordArr);

                    if(dictionary.contains(newWord)){
                        List<String> newBranch = new ArrayList<>(words);
                        newBranch.add(newWord);
                        queue.add(new ArrayList<>(newBranch));
                        usedWords.add(newWord);
                    }
                }
            }
        }

        return shortestTransformations;
    }
}