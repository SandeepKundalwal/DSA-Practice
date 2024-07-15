import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int limit = 4;
        int queries[][] = {{1,4},{2,5},{1,3},{3,4}};
        System.out.println(Arrays.toString(queryResults(limit, queries)));
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int q = queries.length;
        Map<Integer, Integer> ballToColorMap = new HashMap<>();
        Map<Integer, Integer> colorToBallCountMap = new HashMap<>();

        int result[] = new int[q];
        for(int i = 0; i < q; i++){
            int ball = queries[i][0];
            int newColor = queries[i][1];

            if(ballToColorMap.containsKey(ball)){
                int color = ballToColorMap.get(ball);

                if(colorToBallCountMap.get(color) == 1){
                    colorToBallCountMap.remove(color);
                } else {
                    colorToBallCountMap.put(color, colorToBallCountMap.get(color) - 1);
                }
            }

            ballToColorMap.put(ball, newColor);
            colorToBallCountMap.put(newColor, colorToBallCountMap.getOrDefault(newColor, 0) + 1);

            result[i] = colorToBallCountMap.size();
        }

        return result;
    }
}