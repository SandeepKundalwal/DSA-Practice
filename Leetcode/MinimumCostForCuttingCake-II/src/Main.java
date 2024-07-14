import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int horizontalCut[] = {1, 3};
        int verticalCut[] = {5};
        System.out.println(minimumCost(m, n, horizontalCut, verticalCut));
    }

    public static long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(verticalCut);
        Arrays.sort(horizontalCut);

        long cost = 0;
        int hCut = 1, vCut = 1;
        int vIdx = verticalCut.length - 1, hIdx = horizontalCut.length - 1;
        while(vIdx >= 0 && hIdx >= 0){
            if(verticalCut[vIdx] > horizontalCut[hIdx]){
                cost += ((long) hCut * verticalCut[vIdx]);
                vCut++;
                vIdx--;
            } else {
                cost += ((long) vCut * horizontalCut[hIdx]);
                hCut++;
                hIdx--;
            }
        }

        while(vIdx >= 0){
            cost += ((long) hCut * verticalCut[vIdx--]);
        }

        while(hIdx >= 0){
            cost += ((long) vCut * horizontalCut[hIdx--]);
        }

        return cost;
    }
}