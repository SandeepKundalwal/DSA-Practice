public class Main {
    public static void main(String[] args) {
        int money = 3;
        int prices[] = {3,2,3};
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int price : prices){
            if(price < firstMin){
                secondMin = firstMin;
                firstMin = price;
            } else if (price < secondMin){
                secondMin = price;
            }
        }

        int remainingMoney = money - (firstMin + secondMin);
        return remainingMoney < 0 ? money : remainingMoney;
    }
}