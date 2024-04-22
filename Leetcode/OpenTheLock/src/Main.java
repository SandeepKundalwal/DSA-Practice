import java.util.*;

public class Main {
    public static void main(String[] args) {
        String deadends[] = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;

        Set<String> deadSet = new HashSet<>();
        deadSet.addAll(Arrays.asList(deadends));

        if(deadSet.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");


        int turns = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                List<String> allCombinations = findAllPossibleCombinations(queue.remove());

                for(String combination : allCombinations){
                    if(visited.contains(combination) || deadSet.contains(combination)){
                        continue;
                    }

                    if(target.equals(combination)){
                        return turns + 1;
                    }

                    queue.offer(combination);
                    visited.add(combination);
                }
            }
            turns++;
        }

        return -1;
    }

    public static List<String> findAllPossibleCombinations(String combination){
        List<String> allCombinations = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            char charArr[] = combination.toCharArray();
            char c = charArr[i];

            // turn right
            charArr[i] = (c == '9') ? '0' : (char)(c + 1);
            allCombinations.add(String.valueOf(charArr));

            //turn left
            charArr[i] = (c == '0') ? '9' : (char)(c - 1);
            allCombinations.add(String.valueOf(charArr));
        }

        return allCombinations;
    }
}