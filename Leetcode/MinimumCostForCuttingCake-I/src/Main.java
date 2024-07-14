import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int m = 6;
        int n = 3;
        int horizontalCut[] = {2,3,2,3,1};
        int verticalCut[] = {1, 2};
        System.out.println(minimumCost(m, n, horizontalCut, verticalCut));
    }

    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int hCut = 1, vCut = 1;

        Arrays.sort(verticalCut);
        Arrays.sort(horizontalCut);

        int cost = 0;
        int vIdx = verticalCut.length - 1, hIdx = horizontalCut.length - 1;
        while(vIdx >= 0 && hIdx >= 0){
            if(verticalCut[vIdx] > horizontalCut[hIdx]){
                cost += (hCut * verticalCut[vIdx]);
                vCut++;
                vIdx--;
            } else {
                cost += (vCut * horizontalCut[hIdx]);
                hCut++;
                hIdx--;
            }
        }

        while(vIdx >= 0){
            cost += (hCut * verticalCut[vIdx--]);
        }

        while(hIdx >= 0){
            cost += (vCut * horizontalCut[hIdx--]);
        }

        return cost;
    }
}