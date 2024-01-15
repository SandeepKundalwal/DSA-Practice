import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int matches[][] = {
                {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}
        };
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int match[] : matches){
            int winner = match[0];
            int loser = match[1];
            if(!treeMap.containsKey(winner)){
                treeMap.put(winner, 0);
            }

            if(!treeMap.containsKey(loser)){
                treeMap.put(loser, 0);
            }

            treeMap.put(loser, treeMap.get(loser) + 1);
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for(Map.Entry<Integer, Integer> it : treeMap.entrySet()){
            int player = it.getKey();
            int lostGames = it.getValue();
            if(lostGames == 0){
                answer.get(0).add(player);
            } else if(lostGames == 1){
                answer.get(1).add(player);
            }
        }

        return answer;
    }
}