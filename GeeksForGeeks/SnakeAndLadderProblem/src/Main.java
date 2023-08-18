import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int N = 8;
        int arr[] = {3, 22, 5, 8, 11, 26, 20, 29, 17, 4, 19, 7, 27, 1, 21, 9};
        System.out.println("Number of Throws Required: " + minThrow(N, arr));
    }

    public static int minThrow(int N, int arr[]){
        // code here
        Map<Integer, Integer> ladderMap = new HashMap<>();
        Map<Integer, Integer> snakeMap = new HashMap<>();
        for(int i = 0; i < N * 2; i += 2){
            if(arr[i] <= arr[i + 1]){
                ladderMap.put(arr[i], arr[i + 1]);
            } else {
                if(arr[i] == 30){
                    continue;
                }
                snakeMap.put(arr[i], arr[i + 1]);
            }
        }

        int MEMO[] = new int[31];
        Arrays.fill(MEMO, -1);
        return f(1, ladderMap, snakeMap, MEMO);
    }

    public static int f(int idx, Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap, int MEMO[]){
        if(idx >= 30){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        int minThrows = Integer.MAX_VALUE;
        for(int dice = 1; dice <= 6; dice++){
            int newIdx = idx + dice;

            if(ladderMap.containsKey(newIdx) && ladderMap.get(newIdx) <= 30){
                minThrows = Math.min(minThrows, 1 + f(ladderMap.get(newIdx), ladderMap, snakeMap, MEMO));
            } else if(snakeMap.containsKey(newIdx)){
                continue;
            } else {
                minThrows = Math.min(minThrows, 1 + f(newIdx, ladderMap, snakeMap, MEMO));
            }
        }

        return MEMO[idx] = minThrows;
    }
}