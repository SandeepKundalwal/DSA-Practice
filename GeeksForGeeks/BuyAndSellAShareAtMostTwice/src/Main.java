import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int price[] = new int[n];
        for(int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        }

        System.out.println(maxProfit(n, price));
    }

    public static int maxProfit(int n, int[] price) {
        if(price.length == 1){
            return 0;
        }

        int AHEAD[][] = new int[2][3];
        int CURR[][] = new int[2][3];

        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                for(int capacity = 1; capacity <= 2; capacity++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-price[idx] + AHEAD[0][capacity], AHEAD[1][capacity]);
                    } else {
                        profit = Math.max(price[idx] + AHEAD[1][capacity - 1], AHEAD[0][capacity]);
                    }

                    CURR[buy][capacity] = profit;
                }
            }
            AHEAD = CURR;
        }
        return AHEAD[1][2];
    }
}