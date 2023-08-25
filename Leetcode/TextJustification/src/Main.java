import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int maxWidth = 16;
        String words[] = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(fullJustify(words, maxWidth));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < words.length;){
            List<String> wordsInLine = getLineWords(i, words, maxWidth);
//            for(String word : wordsInLine){
//                System.out.print(word + " ");
//            }
            i += wordsInLine.size();
            ans.add(generateLine(wordsInLine, maxWidth));
        }
        return ans;
    }

    private static List<String> getLineWords(int i, String[] words, int maxWidth) {
        List<String> wordsInLine = new ArrayList<>();
        int lineLength = 0;

        while(i < words.length && lineLength + words[i].length() <= maxWidth){
            wordsInLine.add(words[i]);
            lineLength += words[i].length() + 1;
            i++;
        }
        return wordsInLine;
    }

    private static String generateLine(List<String> line, int maxWidth) {
        int lenOfLine = 0;
        int spacesToBeInserted = 0;

        for(String word : line){
            lenOfLine += word.length();
        }

        spacesToBeInserted = maxWidth - lenOfLine;
        StringBuilder finalString = new StringBuilder();

        if(line.size() == 1){
            finalString.append(line.get(0)).append(" ".repeat(spacesToBeInserted));
        } else {
            for(int idx = 0; idx < line.size() - 1;){
                line.set(idx, line.get(idx) + " ");
                spacesToBeInserted--;
                idx++;
                if(idx == line.size() - 1 && spacesToBeInserted > 0){
                    idx = 0;
                } else if (idx == line.size() - 1 && spacesToBeInserted == 0){
                    break;
                }
            }

            for(String word : line){
                finalString.append(word);
            }
        }
        return finalString.toString();
    }
}