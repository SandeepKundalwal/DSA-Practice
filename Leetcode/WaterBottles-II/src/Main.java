public class Main {
    public static void main(String[] args) {
        int numBottles = 13;
        int numExchange = 6;
        System.out.println(maxBottlesDrunk(numBottles, numExchange));
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        return f(numBottles, 0, numExchange);
    }

    public static int f(int fullBottles, int emptyBottles, int numExchange){
        if(fullBottles + emptyBottles < numExchange){
            return fullBottles;
        }

        int dontDrink = 0;
        if(emptyBottles >= numExchange){
            dontDrink = 0 + f(fullBottles + 1, emptyBottles - numExchange, numExchange + 1);
        }

        int drink = 0;
        if(fullBottles != 0){
            drink = fullBottles + f(0, fullBottles + emptyBottles, numExchange);
        }

        return Math.max(dontDrink, drink);
    }
}