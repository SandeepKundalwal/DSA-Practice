import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int target = 2;
        int variables[][] = {
                {2,3,3,10},
                {3,3,3,1},
                {6,1,1,4}
        };
        System.out.println(getGoodIndices(variables, target));
    }

    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> goodIndices = new ArrayList<>();
        for(int i = 0; i < variables.length; i++){
            if(formula(variables[i]) == target){
                goodIndices.add(i);
            }
        }
        return goodIndices;
    }

    public static int formula(int variable[]){
        int a = variable[0];
        int b = variable[1];
        int c = variable[2];
        int m = variable[3];

        int first = 1;
        for(int i = 0; i < b; i++){
            first = (first * a) % 10;
        }

        int second = 1;
        for(int i = 0; i < c; i++){
            second = ((second * first) % m);
        }

        return second;
    }
}