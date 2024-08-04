import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int pick[][] = {{0,8},{0,3}};
        System.out.println(winningPlayerCount(n, pick));
    }

    public static int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer, Integer>> hashMap = new HashMap<>();

        for(int i = 0; i < pick.length; i++){
            int player = pick[i][0];
            int ballColor = pick[i][1];

            if(!hashMap.containsKey(player)){
                hashMap.put(player, new HashMap<>());
            }

            if(!hashMap.get(player).containsKey(ballColor)){
                hashMap.get(player).put(ballColor, 1);
            } else {
                hashMap.get(player).put(ballColor, hashMap.get(player).get(ballColor) + 1);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(hashMap.containsKey(i)){
                for(Map.Entry<Integer, Integer> it : hashMap.get(i).entrySet()){
                    if(it.getValue() > i){
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}