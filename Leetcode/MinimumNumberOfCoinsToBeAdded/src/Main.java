import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int coins[] = {1,4,10,5,7,19};
        int target = 19;
        System.out.println(minimumAddedCoins(coins, target));
    }

    public static int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);

        long maxMoney = 0;
        int coinsNeeded = 0;

        int idx = 0;
        while(maxMoney < target){
            if(idx < coins.length && maxMoney + 1 >= coins[idx]){
                maxMoney += coins[idx++];
            } else {
                coinsNeeded++;
                maxMoney += (maxMoney + 1);
            }
        }

        return coinsNeeded;
    }
}