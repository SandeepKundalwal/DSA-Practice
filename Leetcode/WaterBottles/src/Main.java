public class Main {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(17, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int maxi = numBottles;
        while(numBottles >= numExchange){
            int remainingBottles = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            maxi += numBottles;
            numBottles += remainingBottles;
        }

        return maxi;
    }
}