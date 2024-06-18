import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int difficulty[] = {68,35,52,47,86};
        int profit[] = {67,17,1,81,3};
        int worker[] = {92,10,85,84,82};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m = worker.length;
        int n = difficulty.length;

        Pair diPr[] = new Pair[n];

        for(int i = 0; i < n; i++){
            diPr[i] = new Pair(profit[i], difficulty[i]);
        }

        Arrays.sort(worker);
        Arrays.sort(diPr, (a, b) -> (a.profit - b.profit));

        int maxi = 0;
        int wIdx = m - 1;
        int diPrIdx = n - 1;
        while(diPrIdx >= 0){
            while(wIdx >= 0 && worker[wIdx] >= diPr[diPrIdx].difficulty){
                maxi += diPr[diPrIdx].profit;
                wIdx--;
            }
            diPrIdx--;
        }

        return maxi;
    }

    static class Pair{
        int profit;
        int difficulty;

        public Pair(int profit, int difficulty){
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }
}