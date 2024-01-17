import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int answers[] = {6,9,2,1};
        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        testcases.add(new int[]{4,2,0,3,2,5});
        testcases.add(new int[]{2,0,2});
        testcases.add(new int[]{5,4,1,2});

        for(int i = 0; i < testcases.size(); i++){
            System.out.println(answers[i] + " == " + trap(testcases.get(i)));
        }
    }

    public static int trap(int[] height) {
        int trappedWater = 0;
        for(int i = 0; i < height.length; i++){
            int maxLeft = maxLeft(i, height);
            int maxRight = maxRight(i, height);
            if(maxLeft == 0 || maxRight == 0){
                continue;
            } else {
                int water = (Math.min(maxLeft, maxRight) - height[i]);
                trappedWater += (water < 0 ? 0 : water);
            }
        }
        return trappedWater;
    }

    public static int maxLeft(int idx, int height[]){
        int maxHeight = 0;
        for(int i = 0; i < idx; i++){
            maxHeight = Math.max(maxHeight, height[i]);
        }
        return maxHeight;
    }

    public static int maxRight(int idx, int height[]){
        int maxHeight = 0;
        for(int i = idx + 1; i < height.length; i++){
            maxHeight = Math.max(maxHeight, height[i]);
        }
        return maxHeight;
    }
}